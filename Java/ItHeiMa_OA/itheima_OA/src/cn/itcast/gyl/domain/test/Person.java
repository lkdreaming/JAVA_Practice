package cn.itcast.gyl.domain.test;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	private Long pid;  //标示符属性  在hibernate中根据标示符属性识别缓存中的对象
	private String name;	
	private Date time;

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
