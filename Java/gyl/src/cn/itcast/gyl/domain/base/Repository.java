package cn.itcast.gyl.domain.base;

import java.io.Serializable;
import java.util.Set;

public class Repository implements Serializable{
	private Long rid;
	private String name;
	private String manager;//库管员
	private Set<Product> products;
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
