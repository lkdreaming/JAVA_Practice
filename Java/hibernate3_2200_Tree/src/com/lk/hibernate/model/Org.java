package com.lk.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Org {
	private int id;
	private String name;
	private Org parent;
	private Set<Org> children = new HashSet<Org>();
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@ManyToOne
	@JoinColumn(name="parent_id")
	public Org getParent() {
		return parent;
	}
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="parent")
	public Set<Org> getChildren() {
		return children;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(Org parent) {
		this.parent = parent;
	}
	public void setChildren(Set<Org> children) {
		this.children = children;
	}
}
