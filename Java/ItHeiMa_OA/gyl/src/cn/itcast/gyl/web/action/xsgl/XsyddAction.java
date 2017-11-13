package cn.itcast.gyl.web.action.xsgl;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.gyl.domain.xsgl.Xsyddzhib;
import cn.itcast.gyl.domain.xsgl.Xsyddzhub;
import cn.itcast.gyl.query.PageResult;
import cn.itcast.gyl.query.xsgl.XsyddzhibQuery;
import cn.itcast.gyl.query.xsgl.XsyddzhubQuery;
import cn.itcast.gyl.utils.GylUtils;
import cn.itcast.gyl.xsgl.service.XsyddService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 销售预订单action
 * @author zd
 *
 */
@Controller("xsyddAction")
@Scope("prototype")
public class XsyddAction extends ActionSupport{
	@Resource(name="xsyddService")
	private XsyddService xsyddService;

    /**
     * 用于有两个
     *    1、销售预订单的主表的信息的回显
     *    2、接收增加销售预订单的时候的主表的信息
     *    3、由于点击销售预定单的查询按钮时,发出的请求并不是接受参数的请求,所以struts2不会帮助你new出来
     *    XsyddzhubQuery对象的.只能自己new,自己初始化,子表同理
     */
	private XsyddzhubQuery query_zhub = new XsyddzhubQuery();
	
	/**
	 * 在页面上如果点击主表上的内容，需要加载子表中的内容，这个时候需要获取主表的ID值
	 */
	private XsyddzhibQuery query_zhib = new XsyddzhibQuery();
	
	/**
	 * 用于接收增加销售预订单的时候的子表的信息，因为有很多个，所以这里是一个集合
	 */
	private List<Xsyddzhib> xsyddzhibs;
	
	
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

	public List<Xsyddzhib> getXsyddzhibs() {
		return xsyddzhibs;
	}

	public void setXsyddzhibs(List<Xsyddzhib> xsyddzhibs) {
		this.xsyddzhibs = xsyddzhibs;
	}

	public XsyddzhibQuery getQuery_zhib() {
		return query_zhib;
	}

	public void setQuery_zhib(XsyddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}

	public void setQuery_zhub(XsyddzhubQuery query_zhub){
		this.query_zhub = query_zhub;
	}
	
	public XsyddzhubQuery getQuery_zhub(){
		return this.query_zhub;
	}
	
	public String showAllXsydd(){
		PageResult<Xsyddzhub> pageResult_zhub = this.xsyddService.getEntityPageResult_Zhu(query_zhub);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		PageResult<Xsyddzhib> pageResult_zhib = this.xsyddService.getEntityPageResult_Zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "xsyddList";
	}
	
	public String addUI(){
		return "xsyddAddUI";
	}
	
	public String add(){
		Xsyddzhub xsyddzhub = new Xsyddzhub();
		BeanUtils.copyProperties(query_zhub, xsyddzhub);
		Long id = this.xsyddService.getMaxId();
		//设置订单号
		xsyddzhub.setDdh(GylUtils.ddH(id));
		xsyddzhub.setXsyddzhibs(new HashSet<Xsyddzhib>(xsyddzhibs));
		this.xsyddService.saveEntry(xsyddzhub);
		return "action2action";
	}
	
	/**
	 * 当点击左侧树的节点的更新的时候，跳转到右侧页面的更新页面 
	 * @return
	 */
	public String updateUI(){
		return "xsyddUpdateUI";
	}
	
	/**
	 * 当输入订单号点击查询的时候再次跳转到查询页面
	 * @return
	 */
	public String updateUI_Info(){
		Xsyddzhub xsyddzhub = this.xsyddService.getEntity_Zhu(query_zhub.getDdh());
		BeanUtils.copyProperties(xsyddzhub, query_zhub);
		query_zhib.setXsyddzhubid(xsyddzhub.getXsyddzhubid());
		PageResult<Xsyddzhib> pageResult_zhib = this.xsyddService.getEntityPageResult_Zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "xsyddUpdateUI";
	}
	
	public String update(){
		/**
		 * 从页面上得到的item的值有两种表现形式
		 *     dhrq_zhu    这是对主表中的其中一个字段进行修改
		 *     dw_zhi      这是对子表中的其中一个字段进行修改
		 */
		//主表的字段
		String temp = this.item.split("_")[0];
		//动态拼接要修改的主表的某一个字段的方法的名称
		String methodName = "set"+(""+temp.charAt(0)).toUpperCase()+temp.substring(1);
		if(this.item.split("_")[1].equals("zhu")){//修改主表
			Xsyddzhub xsyddzhub = this.xsyddService.getEntity_Zhu(ddh);
			
			try {
				//得到方法的method,然后利用java的反射机制进行调用
				Method method = xsyddzhub.getClass().getMethod(methodName, String.class);
				/**
				 * item为主表中字段的名字
				 * 页面上传递过来的字段的值为
				 */
				String methodValue = ServletActionContext.getRequest().getParameter(item);
				/**
				 * 利用java的反射机制给页面上主表字段的值赋值到主表相应的方法中利用set方法
				 */
				method.invoke(xsyddzhub, methodValue);
				this.xsyddService.updateEntry_Zhu(xsyddzhub);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{//修改子表
			Xsyddzhib xsyddzhib = this.xsyddService.getEntity_Zhi(hh);
			try {
				//得到方法的method,然后利用java的反射机制进行调用
				Method method = xsyddzhib.getClass().getMethod(methodName, String.class);
				/**
				 * item为主表中字段的名字
				 * 页面上传递过来的字段的值为
				 */
				String methodValue = ServletActionContext.getRequest().getParameter(item);
				/**
				 * 利用java的反射机制给页面上主表字段的值赋值到主表相应的方法中利用set方法
				 */
				method.invoke(xsyddzhib, methodValue);
				this.xsyddService.updateEntry_Zhi(xsyddzhib);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "action2action";
	}
}
