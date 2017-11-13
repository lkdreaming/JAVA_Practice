package com.lk.oa.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Department;
import com.lk.oa.model.Duty;
import com.lk.oa.service.DutyService;
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

	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	public String showALLDuties() {
		List<Duty> duties = dutyService.getALLEntry();
		ActionContext.getContext().getValueStack().push(duties);
		return SUCCESS;
	}
	
	/*public String addUI() {
		return addUI;
	}
	
	public String add() {
		Duty duty = new Duty();
		BeanUtils.copyProperties(this.getModel(), duty);
		dutyService.saveEntry(duty);
		return action2action;
	}
	
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
	
	*//**
	 * 进行修改并跳转到列表页面
	 * @return
	 *//*
	public String update() {
		Duty duty = dutyService.getEntryById(getModel().getId());
		BeanUtils.copyProperties(getModel(), duty);
		dutyService.updateEntry(duty);
		return action2action;
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
}
