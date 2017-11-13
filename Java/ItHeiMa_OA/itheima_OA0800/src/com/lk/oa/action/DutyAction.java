package com.lk.oa.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Duty;
import com.lk.oa.model.User;
import com.lk.oa.service.DutyService;
import com.lk.oa.service.UserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用于将数据传递到duty.js(为zTree树准备数据的脚本)上
 * @author Administrator
 *
 */
@Component("dutyAction")
@Scope("prototype")
public class DutyAction extends BaseAction<Duty> {
	private DutyService dutyService;
	private UserService userService;
	private String checkedNodesIdsStr;
	private Long userId;
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	public String showALLDuties() {
		List<Duty> duties = dutyService.getALLEntry();
		/**
		 * 有下面这句话 才能将刚刚执行的操作的数据压到栈顶,这样就能把数据传递到前台的ajax
		 */
		ActionContext.getContext().getValueStack().push(duties);
		return SUCCESS;
	}
	public String add() {
		Duty duty = new Duty();
		BeanUtils.copyProperties(this.getModel(), duty);
		dutyService.saveEntry(duty);
		ActionContext.getContext().getValueStack().push(duty);
		return SUCCESS;
	}
	
	public String delete() {
		dutyService.deleteEntry(getModel().getDutyId());
		return SUCCESS;
	}
	
	/**
	 * 进行修改
	 * @return
	 */
	public String update() {
		Duty duty = dutyService.getEntryById(getModel().getDutyId());
		BeanUtils.copyProperties(getModel(), duty);
		dutyService.updateEntry(duty);
		return SUCCESS;
	}
	
	public String saveUserDuty() {
		User user = userService.getEntryById(userId);
		Set<Duty> duties = dutyService.getEntrysByIds(checkedNodesIdsStr.split(","));
		user.setDuties(duties);
		userService.updateEntry(user);
		return SUCCESS;
	}
	
	public String showCheckedNodeTree() {
		List<Duty> duties = dutyService.getDutiesByUserId(userId);
		ActionContext.getContext().getValueStack().push(duties);
		return SUCCESS;
	}
	
	
	
	/*
	
	*//**
	 * 跳转到修改的页面
	 * @return
	 *//*
	public String updateUI() {
		Duty duty = dutyService.getEntryById(getModel().getId());
		//用于在修改界面上回显内容.
		ActionContext.getContext().getValueStack().push(duty);
		return updateUI;
	}
	
	
	
	public String delete() {
		Duty duty = dutyService.getEntryById(getModel().getId());
		BeanUtils.copyProperties(getModel(), duty);
		//System.out.println(department.getId());
		dutyService.deleteEntry(duty.getId());
		return action2action;
	}*/
	
	
	public DutyService getDutyService() {
		return dutyService;
	}
	@Resource(name="dutyService")
	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}
	public UserService getUserService() {
		return userService;
	}

	public String getCheckedNodesIdsStr() {
		return checkedNodesIdsStr;
	}
	
	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCheckedNodesIdsStr(String checkedNodesIdsStr) {
		this.checkedNodesIdsStr = checkedNodesIdsStr;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
