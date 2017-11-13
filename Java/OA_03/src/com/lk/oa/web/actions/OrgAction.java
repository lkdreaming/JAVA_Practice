package com.lk.oa.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lk.oa.model.Orgnization;
import com.lk.oa.service.OrgService;
import com.opensymphony.xwork2.ActionSupport;

@Component("org")
@Scope("prototype")
public class OrgAction extends ActionSupport{
	private OrgService orgService;
	private List<Orgnization> orgs;
	public OrgService getOrgService() {
		return orgService;
	}
	public List<Orgnization> getOrgs() {
		return orgs;
	}
	
	@Resource(name = "orgService")
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	
	public void setOrgs(List<Orgnization> orgs) {
		this.orgs = orgs;
	}
	
	public String list() {
		this.orgs = this.orgService.loadAllOrgs();
		return "orgList";
	}
	public String add(Orgnization org ,int parentId) {
		orgService.add(org, parentId);
		return "Orgnization add sucess!";
	}
}

