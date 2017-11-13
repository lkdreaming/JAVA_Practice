package com.lk.oa.dao;

import java.util.List;

import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Duty;

public interface DutyDao extends BaseDao<Duty> {
	public List<Duty> getDutiesByUserId(Long userId);		
}
