package cn.itcast.gyl.web.action.xsgl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.gyl.domain.xsgl.Xsckdzhib;
import cn.itcast.gyl.domain.xsgl.Xskpzhib;
import cn.itcast.gyl.domain.xsgl.Xskpzhub;
import cn.itcast.gyl.query.PageResult;
import cn.itcast.gyl.query.xsgl.XsckdzhibQuery;
import cn.itcast.gyl.query.xsgl.XsckdzhubQuery;
import cn.itcast.gyl.query.xsgl.XskpzhibQuery;
import cn.itcast.gyl.query.xsgl.XskpzhubQuery;
import cn.itcast.gyl.xsgl.service.XsckdService;
import cn.itcast.gyl.xsgl.service.XsddService;
import cn.itcast.gyl.xsgl.service.XskpService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ActionConfig;

@Controller("xskpAction")
@Scope("prototype")
public class XskpAction extends ActionSupport{
	@Resource(name="xskpService")
	private XskpService xskpService;
	@Resource(name="xsddService")
	private XsddService xsddService;
	
	private XskpzhubQuery query_zhub = new XskpzhubQuery();
	private XskpzhibQuery query_zhib = new XskpzhibQuery();
	
	/**
	 * 销售开票子表
	 */
	private List<Xskpzhib> xskpzhibs;
	
	public List<Xskpzhib> getXskpzhibs() {
		return xskpzhibs;
	}
	public void setXskpzhibs(List<Xskpzhib> xskpzhibs) {
		this.xskpzhibs = xskpzhibs;
	}
	
	public XskpzhubQuery getQuery_zhub() {
		return query_zhub;
	}
	public void setQuery_zhub(XskpzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}
	public XskpzhibQuery getQuery_zhib() {
		return query_zhib;
	}
	public void setQuery_zhib(XskpzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}
	/**
	 * 跳转到销售开票页面
	 */
	public String addUI(){
		return "addUI";
	}
	
	public String add(){
		this.xskpService.saveXskp(query_zhub, new HashSet(xskpzhibs));
		return "action2action";
	}
	
	public String showXskp(){
		PageResult<Xskpzhub> pageResult_zhub = this.xskpService.getEntityPageResult_Zhu(query_zhub);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhub);
		PageResult<Xskpzhib> pageResult_zhib = this.xskpService.getEntityPageResult_Zhi(query_zhib);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhib);
		return "list";
	}
}
