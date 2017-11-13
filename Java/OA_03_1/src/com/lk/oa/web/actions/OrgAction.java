package com.lk.oa.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.lk.oa.model.Orgnization;
import com.lk.oa.service.OrgService;
import com.opensymphony.xwork2.ActionSupport;

@Component("org")
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
	public String add() {
		Orgnization org = new Orgnization();
		org.setName("≤‚ ‘");
		orgService.add(org, 1);
		return "Orgnization add sucess!";
	}
}

