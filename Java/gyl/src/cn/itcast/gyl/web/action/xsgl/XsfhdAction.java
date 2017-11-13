package cn.itcast.gyl.web.action.xsgl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.gyl.domain.xsgl.Xsckdzhib;
import cn.itcast.gyl.domain.xsgl.Xsckdzhub;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhib;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhub;
import cn.itcast.gyl.query.PageResult;
import cn.itcast.gyl.query.xsgl.XsfhdzhibQuery;
import cn.itcast.gyl.query.xsgl.XsfhdzhubQuery;
import cn.itcast.gyl.xsgl.service.XsddService;
import cn.itcast.gyl.xsgl.service.XsfhdService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("xsfhdAction")
@Scope("prototype")
public class XsfhdAction extends ActionSupport{
	@Resource(name="xsfhdService")
	private XsfhdService xsfhdService;
	@Resource(name="xsddService")
	private XsddService xsddService;
	
	private XsfhdzhubQuery query_zhub = new XsfhdzhubQuery();
	private XsfhdzhibQuery query_zhib = new XsfhdzhibQuery();
	
	private List<Xsfhdzhib> xsfhdzhibs;
	
	public List<Xsfhdzhib> getXsfhdzhibs() {
		return xsfhdzhibs;
	}
	public void setXsfhdzhibs(List<Xsfhdzhib> xsfhdzhibs) {
		this.xsfhdzhibs = xsfhdzhibs;
	}
	public XsfhdzhubQuery getQuery_zhub() {
		return query_zhub;
	}
	public void setQuery_zhub(XsfhdzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}
	public XsfhdzhibQuery getQuery_zhib() {
		return query_zhib;
	}
	public void setQuery_zhib(XsfhdzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}
	
	public String showXsfhd(){
		PageResult<Xsfhdzhub> pageResult_zhub = this.xsfhdService.getEntityPageResult_Zhu(query_zhub);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		PageResult<Xsfhdzhib> pageResult_zhib = this.xsfhdService.getEntityPageResult_Zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "list";
	}
	
	/**
	 * 跳转到销售发货单页面
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 增加销售发货单
	 * @return
	 */
	public String add(){
		this.xsfhdService.saveXsfhd(query_zhub, new HashSet(xsfhdzhibs));
		return "action2action";
	}
}
