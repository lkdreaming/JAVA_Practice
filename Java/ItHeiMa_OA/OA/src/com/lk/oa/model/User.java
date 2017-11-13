package com.lk.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class User implements Serializable {
	private long userId;
	
	private String loginName;
	private String userName;
	private String password;
	private String phone;
	private String email;
	private String sex;
	private Set<Role> roles;
	private Department department;
	
	@Id
	@GeneratedValue
	public long getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getSex() {
		return sex;
	}
	
	@ManyToMany
	public Set<Role> getRoles() {
		return roles;
	}
	
	@ManyToOne
	public Department getDepartment() {
		return department;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	
	
}
