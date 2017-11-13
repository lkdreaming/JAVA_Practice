package cn.itcast.gyl.query;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class PersonQuery extends BaseQuery{
	private Long pid;
	private String name;
	private Date time;
	@Override
	protected void addWhere() {
		if(pid!=null){
			addWhere("o.pid=?",pid);
		}
		if (StringUtils.isNotBlank(name)) {
			addWhere("o.name like ?", "%" + name + "%");
		}
		if(time!=null){
			addWhere("o.time<?",time);
		}
	}
	
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
