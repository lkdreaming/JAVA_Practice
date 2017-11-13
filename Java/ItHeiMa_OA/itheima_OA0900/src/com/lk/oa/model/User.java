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
	
	private String username;
	private String password;
	private String phone;
	private String email;
	private String sex;
	private Set<Duty> duties;
	private Department department;
	
	
	@Id
	@GeneratedValue
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
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
	public Set<Duty> getDuties() {
		return duties;
	}
	
	@ManyToOne
	public Department getDepartment() {
		return department;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
	public void setDuties(Set<Duty> duties) {
		this.duties = duties;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
