package com.lk.oa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_person")
//hibernate4.0²»Ö§³Ö@Table(name="t_person")
public class Person {
	private int id;
	private String name;
	private String sex;
	private String address;
	private String duty;
	private String phone;
	private String description;
	private Orgnization org;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getAddress() {
		return address;
	}
	public String getDuty() {
		return duty;
	}
	public String getPhone() {
		return phone;
	}
	public String getDescription() {
		return description;
	}
	
	@ManyToOne
	public Orgnization getOrg() {
		return org;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setOrg(Orgnization org) {
		this.org = org;
	}
	
	
}
