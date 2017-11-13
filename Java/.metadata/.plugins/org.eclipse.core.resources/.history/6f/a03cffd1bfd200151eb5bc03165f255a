package com.lk.oa.web.actions;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.model.Orgnization;
import com.lk.oa.service.OrgService;
import com.opensymphony.xwork2.ActionSupport;

@Component("org")
public class OrgAction extends ActionSupport {
	private OrgService orgService;

	public OrgService getOrgService() {
		return orgService;
	}
	@Resource(name = "orgService")
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	
	public String add(Orgnization org, int parentId) {
		orgService.add(org, parentId);
		return "Orgnization add sucess!";
	}
	
	public String del(int orgId) {
		orgService.remove(orgId);
		return "Orgnization del sucess!";
	}
	public String update(Orgnization org) {
		orgService.update(org);
		return "Orgnization update sucess!";
	}
	public String load(int orgId) {
		orgService.get(orgId);
		return "Orgnization load sucess!";
	}
	
	
}
