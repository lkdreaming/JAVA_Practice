package cn.itcast.gyl.web.action.xsgl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.gyl.constant.GylConstantKey;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsddzhub;
import cn.itcast.gyl.domain.xsgl.Xsyddzhib;
import cn.itcast.gyl.domain.xsgl.Xsyddzhub;
import cn.itcast.gyl.query.PageResult;
import cn.itcast.gyl.query.xsgl.XsddzhibQuery;
import cn.itcast.gyl.query.xsgl.XsddzhubQuery;
import cn.itcast.gyl.query.xsgl.XsyddzhubQuery;
import cn.itcast.gyl.utils.GylUtils;
import cn.itcast.gyl.xsgl.service.XsddService;
import cn.itcast.gyl.xsgl.service.XsyddService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("xsddAction")
@Scope("prototype")
public class XsddAction extends ActionSupport{
	@Resource(name="xsddService")
	private XsddService xsddService;
	
	@Resource(name="xsyddService")
	private XsyddService xsyddService;

	private XsddzhubQuery query_zhub = new XsddzhubQuery();
	private XsddzhibQuery query_zhib = new XsddzhibQuery();
	/**
	 * 接受销售预订单主表订单号
	 */
	private XsyddzhubQuery xsyddzhubQuery = new XsyddzhubQuery();
	
	
	
	public XsyddzhubQuery getXsyddzhubQuery() {
		return xsyddzhubQuery;
	}

	public void setXsyddzhubQuery(XsyddzhubQuery xsyddzhubQuery) {
		this.xsyddzhubQuery = xsyddzhubQuery;
	}

	private List<Xsddzhib> xsddzhibs;
	
	public List<Xsddzhib> getXsddzhibs() {
		return xsddzhibs;
	}

	public void setXsddzhibs(List<Xsddzhib> xsddzhibs) {
		this.xsddzhibs = xsddzhibs;
	}

	public XsddzhubQuery getQuery_zhub() {
		return query_zhub;
	}

	public void setQuery_zhub(XsddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}

	public XsddzhibQuery getQuery_zhib() {
		return query_zhib;
	}

	public void setQuery_zhib(XsddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}

	/**
	 * 查询销售订单的信息，主表和子表一起的信息
	 */
	public String showXsdd(){
		PageResult<Xsddzhub> pageResult_zhub = this.xsddService.getEntityPageResult_Zhu(query_zhub);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		PageResult<Xsddzhib> pageResult_zhib = this.xsddService.getEntityPageResult_Zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "xsddList";
	}
	
	/**
	 * 跳转到直接生成销售订单的添加页面
	 * @return
	 */
	public String addUI_Direct(){
		return  "xsddAddUI_Direct";
	}
	
	public String add(){
		Xsddzhub xsddzhub = new Xsddzhub();
		BeanUtils.copyProperties(query_zhub, xsddzhub);
		/**
		 * 在主表中设置订单号
		 *   1、获取最新的主表中的主键的最大值
		 *   2、生成新的订单号
		 */
		Long id = this.xsddService.getMaxId();
		xsddzhub.setDdh(GylUtils.ddH(id));
		
		/**
		 * 把页面上子表的数据和主表做关联
		 */
		xsddzhub.setXsddzhibs(new HashSet<Xsddzhib>(xsddzhibs));
		
		/**
		 * 整单价税合计的计算方法：
		 * 	遍历每一个销售预订单的子表的记录：每一条记录的含税金额*(1-单品扣率)
		 */
		Float zdjshj = GylUtils.calculateZDJSHJ_Direct(xsddzhub.getXsddzhibs());
		xsddzhub.setZdjshj(zdjshj);
		
		this.xsddService.saveEntry(xsddzhub);
		return "action2action";
	}
	
	/**
	 * 跳转到销售订单添加页面，该销售订单是由销售预订单生成的
	 * @return
	 */
	public String addUI_FromXsydd(){
		return "xsddAddUIFromXsydd";
	}
	
	/**
	 * 处理由销售预订单生成销售订单
	 */
	public String addFromXsydd(){
		/**
		 * 根据销售预订单的订单号提取信息
		 */
		Xsyddzhub xsyddzhub = this.xsyddService.getEntity_Zhu(xsyddzhubQuery.getDdh());
		/**
		 * 完成从销售预订单到销售订单的信息的复制
		 */
		Xsddzhub xsddzhub = new Xsddzhub();
		BeanUtils.copyProperties(xsyddzhub, xsddzhub);
		/**
		 *   主表的情况
		 */
		xsddzhub.setThbz(GylConstantKey.XSDD_TH_NOT);
		xsddzhub.setCkjsbz(GylConstantKey.CKJSBZ_NO);//出库结束标志
		xsddzhub.setKpjsbz(GylConstantKey.KPJSBZ_NO);//开票结束标志
		xsddzhub.setFhjsbz(GylConstantKey.FHJSBZ_NO);//发货结束标志
		xsddzhub.setLydjh(xsyddzhubQuery.getDdh());//设置来源单据号
		/**
		 * 整单价税合计的计算方法：
		 * 	遍历每一个销售预订单的子表的记录：每一条记录的含税金额*(1-单品扣率)
		 */
		Float zdjshj = GylUtils.calculateZDJSHJ_FromXsydd(xsyddzhub.getXsyddzhibs());
		xsddzhub.setZdjshj(zdjshj); //这个需求还得定一下
		xsddzhub.setSxkje(query_zhub.getSxkje());//收现款金额
		/**
		 * 子表的情况
		 */
		Set<Xsyddzhib> xsyddzhibs = xsyddzhub.getXsyddzhibs();
		Set<Xsddzhib> xsddzhibs = new HashSet<Xsddzhib>();
		for(Xsyddzhib xsyddzhib:xsyddzhibs){
			Xsddzhib xsddzhib = new Xsddzhib();
			BeanUtils.copyProperties(xsyddzhib, xsddzhib);
			/**
			 * 设置销售订单子表中的来源行号     如果是直接生成销售订单，则没有来源行号，如果是根据销售预订单生成的，则来源行号为销售预订单的行号
			 */
			xsddzhib.setLyhh(xsyddzhib.getHh());
			/**
			 * 设置应发未出库数量，因为这个销售订单是根据销售预订单过来的，所以还没有出库，所以应发未出库数量为数量的总和
			 */
			xsddzhib.setYfwcksl(xsyddzhib.getSl());
			xsddzhibs.add(xsddzhib);
		}
		xsddzhub.setXsddzhibs(xsddzhibs);
		this.xsddService.saveEntry(xsddzhub);
		return "action2action";
	}
	
	/**
	 * 跳转到销售退货单的界面       该销售退货单来源于某一个销售订单
	 */
	public String tuihuoUI_fromXsdd(){
		Xsddzhub xsddzhub = this.xsddService.getEntity_Zhu(query_zhub.getDdh());
		BeanUtils.copyProperties(xsddzhub, query_zhub);
		PageResult<Xsddzhib> pageResult_zhib = this.xsddService.getEntityPageResult_Zhi(query_zhub);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "tuihuoUI_fromXsdd";
	}
}
