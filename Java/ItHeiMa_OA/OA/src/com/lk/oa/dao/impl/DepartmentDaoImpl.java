package com.lk.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.lk.oa.dao.DepartmentDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

}
