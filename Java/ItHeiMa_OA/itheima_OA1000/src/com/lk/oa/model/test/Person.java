package com.lk.oa.model.test;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="t_person")
public class Person implements Serializable {
	private long id;
	private String name;
	private Date time;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getTime() {
		return time;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
