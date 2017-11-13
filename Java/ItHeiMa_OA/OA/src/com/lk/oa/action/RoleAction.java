package com.lk.oa.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.Role;
import com.lk.oa.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction {
	private RoleService rs;
	private Collection<Role> roles;
	private long pid;
	private String name;
	private long roleId;
	//private Role role1;
	
	

	public long getPid() {
		return pid;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleService getRs() {
		return rs;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	
	/*public Role getRole1() {
		return role1;
	}

	public void setRole1(Role role1) {
		this.role1 = role1;
	}*/

	@Resource(name = "roleService")
	public void setRs(RoleService rs) {
		this.rs = rs;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	
	public String showAllRoles() {
		this.roles = this.rs.getAllEntries();
		return listAction;
	}
	public String showAllRolesForTree() {
		this.roles = this.rs.getAllEntries();
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	
	public String addUI() {
		return addUI; 
	}
	
	public String add() {
		Role role = new Role();
		role.setName(this.name);
		role.setPid(this.pid);
		this.rs.saveEntry(role);
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	
	public String updateUI() {
		return updateUI;
	}
	
	public String update() {
		Role role = this.rs.getEntryById(this.roleId);
		role.setName(name);
		this.rs.updateEntry(role);
		/**
		 * 沒有下面這句話,role.js就不能執行success下的function了
		 */
		ActionContext.getContext().getValueStack().push(null);
		return SUCCESS;
	}
	
	public String delete() {
		this.rs.deleteEntryById(this.roleId);
		/**
		 * 沒有下面這句話,role.js就不能執行success下的function了
		 */
		ActionContext.getContext().getValueStack().push(null);
		return SUCCESS;
	}
}
