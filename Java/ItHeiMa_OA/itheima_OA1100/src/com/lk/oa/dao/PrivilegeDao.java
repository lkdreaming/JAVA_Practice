package com.lk.oa.dao;

import java.util.List;

import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {
	public List<Privilege> getPrivilegesByDutyId(Long dutyId);
	
	public List<Privilege> getPrivilegesByUserId(Long userId);
	
}
