package cn.itcast.gyl.web.action.xsgl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.gyl.domain.xsgl.Xsysdzhib;
import cn.itcast.gyl.domain.xsgl.Xsysdzhub;
import cn.itcast.gyl.query.PageResult;
import cn.itcast.gyl.query.xsgl.XsysdzhibQuery;
import cn.itcast.gyl.query.xsgl.XsysdzhubQuery;
import cn.itcast.gyl.xsgl.service.XsysdService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 销售应收单
 * @author zd
 *
 */
@Controller("xsysdAction")
@Scope("prototype")
public class XsysdAction extends ActionSupport{
	@Resource(name="xsysdService")
	private XsysdService xsysdService;

	private XsysdzhubQuery query_zhub = new XsysdzhubQuery();

	private XsysdzhibQuery query_zhib = new XsysdzhibQuery();
	
	/**
	 * 用于接收增加销售预订单的时候的子表的信息，因为有很多个，所以这里是一个集合
	 */
	private List<Xsysdzhib> xsysdzhibs;
	
	
	
	public List<Xsysdzhib> getXsysdzhibs() {
		return xsysdzhibs;
	}

	public void setXsysdzhibs(List<Xsysdzhib> xsysdzhibs) {
		this.xsysdzhibs = xsysdzhibs;
	}

	/**
	 * 修改的时候需要的参数
	 * @return
	 */
	private String ddh; //主表中的订单号
	private String item;//主表或者子表中要修改的那一行
	private Long hh;//子表中的行号
	
	public String getDdh() {
		return ddh;
	}

	public void setDdh(String ddh) {
		this.ddh = ddh;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getHh() {
		return hh;
	}

	public void setHh(Long hh) {
		this.hh = hh;
	}
	
	public String addUI(){
		return "addUI";
	}
	
	public String add(){
		this.xsysdService.saveXsysd(query_zhub, new HashSet(xsysdzhibs));
		return "action2action";
	}
	
	public String showXsysd(){
		PageResult<Xsysdzhub> pageResult_zhub = this.xsysdService.getEntityPageResult_Zhu(query_zhub);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		PageResult<Xsysdzhib> pageResult_zhib = this.xsysdService.getEntityPageResult_Zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "list";
	}
}
