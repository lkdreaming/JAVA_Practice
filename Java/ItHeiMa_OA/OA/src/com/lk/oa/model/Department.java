package com.lk.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 * Department模型
 * @author Administrator
 *
 */
@Entity
public class Department implements Serializable {
	private long departmentId;
	private String departmentName;
	private String description;
	private Set<User> users;
	
	@Id
	@GeneratedValue
	public long getDepartmentId() {
		return departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDescription() {
		return description;
	}
	
	@OneToMany
	public Set<User> getUsers() {
		return users;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
}