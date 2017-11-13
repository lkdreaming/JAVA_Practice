package com.lk.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Role implements Serializable {
	private long roleId;//主键
	private long pid;//父节点ID
	private String name; 
	private Boolean isParent;
	private String Description;
	private Set<User> users;
	private Set<Privilege> privileges;
	private Boolean checked = false;
	
	@Id
	@GeneratedValue
	public long getRoleId() {
		return roleId;
	}
	public long getPid() {
		return pid;
	}
	public String getName() {
		return name;
	}
	public Boolean isParent() {
		return isParent;
	}
	public String getDescription() {
		return Description;
	}
	
	@ManyToMany(mappedBy = "roles")
	public Set<User> getUsers() {
		return users;
	}
	
	@ManyToMany
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	
	@Transient
	public Boolean getChecked() {
		return checked;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	
}
