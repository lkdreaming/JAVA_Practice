package com.lk.oa.service;

import java.util.List;

import com.lk.oa.model.Privilege;
import com.lk.oa.service.base.BaseService;


public interface PrivilegeService extends BaseService<Privilege> {
	public List<Privilege> getPrivilegesByDutyId(Long dutyId);
}
