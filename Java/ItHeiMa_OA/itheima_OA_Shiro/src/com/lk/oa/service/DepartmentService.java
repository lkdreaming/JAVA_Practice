package com.lk.oa.service;

import java.util.Collection;

import com.lk.oa.model.Department;
import com.lk.oa.service.base.BaseService;

public interface DepartmentService extends BaseService<Department> {
	
	public Collection<Department> getAllDepartments() ;
	
	
}
