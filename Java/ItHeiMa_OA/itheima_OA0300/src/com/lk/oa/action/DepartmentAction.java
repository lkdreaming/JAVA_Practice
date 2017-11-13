package com.lk.oa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Department;
import com.lk.oa.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;

@Component("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	private DepartmentService departmentService;

	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	public String showALLDepartment() {
		List<Department> departments = departmentService.getALLEntry();
		ActionContext.getContext().put("departments", departments);
		return listAction;
	}
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}
