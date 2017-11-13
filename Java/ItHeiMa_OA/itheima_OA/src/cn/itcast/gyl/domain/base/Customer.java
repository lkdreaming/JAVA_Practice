package cn.itcast.gyl.domain.base;

import java.io.Serializable;

/**
 * 客户表
 * @author zd
 *
 */
public class Customer implements Serializable{
	private Long cid;
	private String name;
	private String phone;
	private String email;
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
