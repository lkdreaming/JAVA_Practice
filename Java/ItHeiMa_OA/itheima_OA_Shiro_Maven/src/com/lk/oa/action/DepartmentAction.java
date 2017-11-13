package com.lk.oa.action;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
		try {
			Collection<Department> departments = departmentService.getAllDepartments	();
			ActionContext.getContext().put("departments", departments);
			return listAction;
		} catch (UnauthenticatedException e) {
			this.addActionError("您无权访问该页,请先登录");
			return "login";
		}
		
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
		Department department = departmentService.getEntryById(getModel().getDepartmentId());
		//用于在修改界面上回显内容.
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	
	/**
	 * 进行修改并跳转到列表页面
	 * @return
	 */
	public String update() {
		Department department = departmentService.getEntryById(getModel().getDepartmentId());
		BeanUtils.copyProperties(getModel(), department);
		this.departmentService.updateEntry(department);
		return action2action;
	}
	
	public String delete() {
		Department department = departmentService.getEntryById(getModel().getDepartmentId());
		BeanUtils.copyProperties(getModel(), department);
		//System.out.println(department.getDepartmentId());
		departmentService.deleteEntry(department.getDepartmentId());
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
