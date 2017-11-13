package com.lk.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.DepartmentDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Department;
import com.lk.oa.service.DepartmentService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

@Component("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {
	
	private DepartmentDao departmentDao;
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	
	@Resource(name="departmentDao")
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	@Override
	public BaseDao<Department> getBaseDao() {
		return departmentDao;
	}

}
