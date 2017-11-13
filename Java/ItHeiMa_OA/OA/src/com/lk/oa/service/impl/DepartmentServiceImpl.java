package com.lk.oa.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lk.oa.dao.DepartmentDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.Department;
import com.lk.oa.service.DepartmentService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {

	private DepartmentDao departmentDao;
	@Override
	public BaseDao getBaseDao() {
		return this.getDepartmentDao();
	}
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	@Resource(name = "departmentDao")
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	public Collection<Department> getAllDepartments() {
		
		return this.getAllEntries();
	}

	
}