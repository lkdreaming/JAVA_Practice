package com.lk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.PrivilegeDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Privilege;
import com.lk.oa.service.PrivilegeService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

@Component("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService {
	private PrivilegeDao privilegeDao;
	
	@Override
	public List<Privilege> getPrivilegesByDutyId(Long dutyId) {
		List<Privilege> privileges = privilegeDao.getPrivilegesByDutyId(dutyId);
		return privileges;
	}

	@Override
	public BaseDao<Privilege> getBaseDao() {
		return privilegeDao;
	}

	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}
	
	@Resource(name = "privilegeDao")
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}


}
