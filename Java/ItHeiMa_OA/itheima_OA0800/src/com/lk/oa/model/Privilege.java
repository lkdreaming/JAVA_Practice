package com.lk.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Privilege implements Serializable {
	private Long privilegeId;
	private String name;
	private Long pid;
	private String icon;
	private Boolean isParent;
	private Set<Duty> duties;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public String getName() {
		return name;
	}
	public Long getPid() {
		return pid;
	}
	public String getIcon() {
		return icon;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	
	@ManyToMany
	public Set<Duty> getDuties() {
		return duties;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public void setDuties(Set<Duty> duties) {
		this.duties = duties;
	}
	
	
	
}
