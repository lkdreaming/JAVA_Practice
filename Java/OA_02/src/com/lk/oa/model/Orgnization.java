package com.lk.oa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orgnization {
	private int id;
	private String name;
	private String sn;
	private String description;
	private Orgnization parent;
	private Set<Orgnization> children = new HashSet<Orgnization>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSn() {
		return sn;
	}
	public String getDescription() {
		return description;
	}
	
	@ManyToOne
	//hibernate4��֧��@JoinColumn   ֻд@ManyToOne
	public Orgnization getParent() {
		return parent;
	}
	
	@OneToMany(mappedBy = "parent" ,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	public Set<Orgnization> getChildren() {
		return children;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setParent(Orgnization parent) {
		this.parent = parent;
	}
	public void setChildren(Set<Orgnization> children) {
		this.children = children;
	}
}