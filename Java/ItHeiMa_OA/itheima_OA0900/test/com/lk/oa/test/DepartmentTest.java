package com.lk.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.model.Department;
import com.lk.oa.service.DepartmentService;

public class DepartmentTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	DepartmentService departmentService = (DepartmentService) ctx.getBean("departmentService");
	Department department;
	
	@Test
	public void saveDepartment() {
		department = new Department();
		department.setName("行政部");
		department.setDescription("不受待见的部门");
		departmentService.saveEntry(department);
	}
	
	@Test
	public void getAllDepartment() {
		saveDepartment();
		department = new Department();
		departmentService.getALLEntry();
		
	}
	
	@Test
	public void deleteDepartment() {
		saveDepartment();
		departmentService.deleteEntry(department);
	}
}
