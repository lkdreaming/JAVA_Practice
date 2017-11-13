package com.lk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.DutyDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Duty;
import com.lk.oa.service.DutyService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

@Component("dutyService")
public class DutyServiceImpl extends BaseServiceImpl<Duty> implements DutyService {
	private DutyDao dutyDao;
	
	@Override
	public BaseDao<Duty> getBaseDao() {
		return dutyDao;
	}

	public DutyDao getDutyDao() {
		return dutyDao;
	}

	@Resource(name="dutyDao")
	public void setDutyDao(DutyDao dutyDao) {
		this.dutyDao = dutyDao;
	}

	@Override
	public List<Duty> getDutiesByUserId(Long userId) {
		List<Duty> duties = dutyDao.getDutiesByUserId(userId);
		return duties;
	}
	
	

}
