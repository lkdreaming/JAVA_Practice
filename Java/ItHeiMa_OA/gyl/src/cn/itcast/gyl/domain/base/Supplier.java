package cn.itcast.gyl.domain.base;

import java.io.Serializable;

/**
 * 供应商表
 * @author zd
 *
 */
public class Supplier implements Serializable{
	private Long sid;
	private String name;//供应商的名称
	private String address;
	private String phone;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
