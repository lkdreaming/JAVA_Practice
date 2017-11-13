package com.lk.oa.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Department;
import com.lk.oa.model.Duty;
import com.lk.oa.model.User;
import com.lk.oa.service.DepartmentService;
import com.lk.oa.service.DutyService;
import com.lk.oa.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Component("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	private UserService userService;
	private DepartmentService departmentService;
	private DutyService dutyService;
	private Long departmentId;
	private Long[] dutyIds;
	public UserService getUserService() {
		return userService;
	}

	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public DutyService getDutyService() {
		return dutyService;
	}
	
	@Resource(name = "departmentService")
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@Resource(name = "dutyService")
	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}


	public Long getDepartmentId() {
		return departmentId;
	}

	public Long[] getDutyIds() {
		return dutyIds;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public void setDutyIds(Long[] dutyIds) {
		this.dutyIds = dutyIds;
	}

	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	public String showALLUsers() {
		List<User> users = userService.getALLEntry();
		ActionContext.getContext().put("users", users);
		return listAction;
	}
	
	public String addUI() {
		List<Department> departments = departmentService.getALLEntry();
		List<Duty> duties = dutyService.getALLEntry();
		ActionContext.getContext().put("departments", departments);
		ActionContext.getContext().put("duties", duties);	
		return addUI;
	}
	
	public String add() {
		User user = new User();
		BeanUtils.copyProperties(this.getModel(), user);
		Department department = departmentService.getEntryById(departmentId);
		Set<Duty> duties = dutyService.getEntrysByIds(dutyIds);
		user.setDepartment(department);
		user.setDuties(duties);
		userService.saveEntry(user);
		return action2action;
	}
	
	/**
	 * 跳转到修改的页面
	 * @return
	 */
	public String updateUI() {
		User user = userService.getEntryById(getModel().getId());
		//把user放到栈顶用于回显.
		ActionContext.getContext().getValueStack().push(user);
		departmentId = user.getDepartment().getDepartmentId();
		dutyIds = new Long[user.getDuties().size()];//这部必须得有呢?
		int index = 0;
		/*
		for(Duty duty : user.getDuties()) {
			dutyIds[index] = duty.getDutyId();
			index ++;
			System.out.println(dutyIds.length);
		}
		*/
		Iterator<Duty> it = user.getDuties().iterator();
		//it.hasNext();
		while(it.hasNext()) {
			Duty duty = it.next();
			dutyIds[index] = duty.getDutyId();
			index++;
		}
		List<Department> departments = departmentService.getALLEntry();
		List<Duty> duties = dutyService.getALLEntry();
		ActionContext.getContext().put("departments", departments);
		ActionContext.getContext().put("duties", duties);	
		return updateUI;
		
	}
	
	/**
	 * 进行修改并跳转到列表页面
	 * @return
	 */
	public String update() {
		User user = userService.getEntryById(getModel().getId());
		BeanUtils.copyProperties(getModel(), user);
		Department department = departmentService.getEntryById(departmentId);
		Set<Duty> duties = dutyService.getEntrysByIds(dutyIds);
		user.setDepartment(department);
		user.setDuties(duties);
		userService.updateEntry(user);
		return action2action;
	}
	
	public String delete() {
		User user = userService.getEntryById(getModel().getId());
		BeanUtils.copyProperties(getModel(), user);
		//System.out.println(department.getId());
		userService.deleteEntry(user.getId());
		return action2action;
	}
	
	
}
