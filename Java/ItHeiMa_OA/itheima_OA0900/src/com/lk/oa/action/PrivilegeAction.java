package com.lk.oa.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Duty;
import com.lk.oa.model.Privilege;
import com.lk.oa.service.DutyService;
import com.lk.oa.service.PrivilegeService;
import com.opensymphony.xwork2.ActionContext;

@Component("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege> {
	private PrivilegeService privilegeService;
	private DutyService dutyService;
	private Long dutyId;
	private String checkedPrivilegeIdsStr;
	
	public String showPrivilegeByDutyId() {
		List<Privilege> privileges = privilegeService.getPrivilegesByDutyId(dutyId);
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
	
	public String saveDutyPrivilege() {
		Duty duty = dutyService.getEntryById(dutyId);
		Set<Privilege> privileges = privilegeService.getEntrysByIds(checkedPrivilegeIdsStr.split(","));
		duty.setPrivileges(privileges);
		dutyService.updateEntry(duty);
		return SUCCESS;
	}
	
	
	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}
	public Long getDutyId() {
		return dutyId;
	}
	
	@Resource(name = "privilegeService")
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
	
	public void setDutyId(Long dutyId) {
		this.dutyId = dutyId;
	}

	public DutyService getDutyService() {
		return dutyService;
	}

	@Resource(name = "dutyService")
	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}

	public String getCheckedPrivilegeIdsStr() {
		return checkedPrivilegeIdsStr;
	}

	public void setCheckedPrivilegeIdsStr(String checkedPrivilegeIdsStr) {
		this.checkedPrivilegeIdsStr = checkedPrivilegeIdsStr;
	}
}
