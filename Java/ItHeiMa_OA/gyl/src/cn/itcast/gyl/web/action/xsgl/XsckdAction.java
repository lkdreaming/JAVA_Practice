package cn.itcast.gyl.web.action.xsgl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.gyl.domain.xsgl.Xsckdzhib;
import cn.itcast.gyl.domain.xsgl.Xsckdzhub;
import cn.itcast.gyl.query.PageResult;
import cn.itcast.gyl.query.xsgl.XsckdzhibQuery;
import cn.itcast.gyl.query.xsgl.XsckdzhubQuery;
import cn.itcast.gyl.xsgl.service.XsckdService;
import cn.itcast.gyl.xsgl.service.XsddService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("xsckdAction")
@Scope("prototype")
public class XsckdAction extends ActionSupport{
	@Resource(name="xsckdService")
	private XsckdService xsckdService;
	@Resource(name="xsddService")
	private XsddService xsddService;
	
	private XsckdzhubQuery query_zhub = new XsckdzhubQuery();
	private XsckdzhibQuery query_zhib = new XsckdzhibQuery();
	
	/**
	 * 销售出库单子表
	 */
	private List<Xsckdzhib> xsckdzhibs;
	
	public List<Xsckdzhib> getXsckdzhibs() {
		return xsckdzhibs;
	}
	public void setXsckdzhibs(List<Xsckdzhib> xsckdzhibs) {
		this.xsckdzhibs = xsckdzhibs;
	}
	public XsckdzhubQuery getQuery_zhub() {
		return query_zhub;
	}
	public void setQuery_zhub(XsckdzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}
	public XsckdzhibQuery getQuery_zhib() {
		return query_zhib;
	}
	public void setQuery_zhib(XsckdzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}
	
	public String showXsckd(){
		PageResult<Xsckdzhub> pageResult_zhub = this.xsckdService.getEntityPageResult_Zhu(query_zhub);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		PageResult<Xsckdzhib> pageResult_zhib = this.xsckdService.getEntityPageResult_Zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "list";
	}
	
	/**
	 * 跳转到销售出库单页面
	 */
	public String addUI(){
		return "addUI";
	}
	
	public String add(){
		this.xsckdService.saveXsckd(query_zhub, new HashSet(xsckdzhibs));
		return "action2action";
	}
}
