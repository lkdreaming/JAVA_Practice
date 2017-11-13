package com.lk.oa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Privilege implements Serializable {
	private Long privilegeId;
	private String name;
	private Long pid;
	private String icon;
	private Boolean isParent;
	private Set<Duty> duties;
	private Boolean checked;
	private String url;
	private String target;
	private int type = 1;
	
	@Id
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
	
	@ManyToMany(mappedBy = "privileges")
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
	
	@Transient
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getUrl() {
		return url;
	}
	public String getTarget() {
		return target;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}