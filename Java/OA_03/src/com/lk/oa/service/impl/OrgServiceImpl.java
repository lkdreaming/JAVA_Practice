package com.lk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.OrgDao;
import com.lk.oa.model.Orgnization;
import com.lk.oa.service.OrgService;

@Component("orgService")
public class OrgServiceImpl implements OrgService {
	private OrgDao orgDao;

	

	public OrgDao getOrgDao() {
		return orgDao;
	}
	
	@Resource
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	public void add(Orgnization org, int parentId) {
		orgDao.save(org, parentId);

	}

	public void remove(int orgId) {
		orgDao.delete(orgId);

	}

	public void update(Orgnization org) {
		orgDao.update(org);
	}

	public Orgnization get(int orgId) {
		return orgDao.get(orgId);
	}

	@Override
	public List<Orgnization> loadChildren(int parentId) {
		return orgDao.loadChildren(parentId);
	}

	@Override
	public List<Orgnization> loadAllOrgs() {
		
		return orgDao.loadAllOrgs();
	}
	
	

}
