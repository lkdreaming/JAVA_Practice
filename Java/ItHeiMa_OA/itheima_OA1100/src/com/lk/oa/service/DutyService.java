package com.lk.oa.service;

import java.util.List;

import com.lk.oa.model.Duty;
import com.lk.oa.service.base.BaseService;

public interface DutyService extends BaseService<Duty> {
	public List<Duty> getDutiesByUserId(Long userId);
}
