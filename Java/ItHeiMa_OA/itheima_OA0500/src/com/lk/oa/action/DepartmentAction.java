package com.lk.oa.action;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
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
	
	public String addUI() {
		return addUI;
	}
	
	public String add() {
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		departmentService.saveEntry(department);
		return action2action;
	}
	
	/**
	 * 跳转到修改的页面
	 * @return
	 */
	public String updateUI() {
		Department department = departmentService.getEntryById(getModel().getId());
		//用于在修改界面上回显内容.
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	
	/**
	 * 进行修改并跳转到列表页面
	 * @return
	 */
	public String update() {
		Department department = departmentService.getEntryById(getModel().getId());
		BeanUtils.copyProperties(getModel(), department);
		this.departmentService.updateEntry(department);
		return action2action;
	}
	
	public String delete() {
		Department department = departmentService.getEntryById(getModel().getId());
		BeanUtils.copyProperties(getModel(), department);
		//System.out.println(department.getId());
		departmentService.deleteEntry(department.getId());
		return action2action;
	}
	
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource(name="departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}
