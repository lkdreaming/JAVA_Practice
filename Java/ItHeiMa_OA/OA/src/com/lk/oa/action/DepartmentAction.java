package com.lk.oa.action;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Department;
import com.lk.oa.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction {
	private DepartmentService ds;
	private Department department;
	private Collection<Department> departments;
	private long departmentId;
	
	public DepartmentService getDs() {
		return ds;
	}
	@Resource(name = "departmentService")
	public void setDs(DepartmentService ds) {
		this.ds = ds;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Serializable getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	
	
	public Collection<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(Collection<Department> departments) {
		this.departments = departments;
	}
	/**
	 * 列出所有部门
	 * @return
	 */
	public String showAllDepartments() {
		departments = this.ds.getAllDepartments();
		//ActionContext.getContext().put("departments", departments);
		return listAction;
	}
	
	/**
	 * 跳转到add.jsp
	 * @return
	 */
	public String addUI() {
		return addUI;
	}
	
	public String add() {
		this.ds.saveEntry(department);
		return Action2Action;
	}
	
	public String updateUI() {
		department = this.ds.getEntryById(this.departmentId);
		return updateUI;
	}
	
	public String update() {
		Department department1 = this.ds.getEntryById(departmentId);
		this.ds.updateEntry(department1);
		return Action2Action;
	}
	
	public String delete() {
		this.ds.deleteEntryById(departmentId);
		return Action2Action;
	}
	
	
	
}
