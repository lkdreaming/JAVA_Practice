package cn.itcast.gyl.domain.base;

import java.io.Serializable;
import java.util.Set;

public class Product implements Serializable{
	private Long pid;
	private String name; //商品名称
	private String xinghao;//型号
	private String bm;//编码
	private String dw;//单位
	private Set<Repository> repositories;
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
	public String getXinghao() {
		return xinghao;
	}
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Set<Repository> getRepositories() {
		return repositories;
	}
	public void setRepositories(Set<Repository> repositories) {
		this.repositories = repositories;
	}
}
