package com.lk.bbs;
import java.sql.*;
import java.util.Date;

public class Article {
	private int id;
	private int pid;
	private int rootid;
	private String title;
	private String cont;
	private boolean isLeaf;
	private int grade;
	private Date pdate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getRootid() {
		return rootid;
	}
	
	public void setRootid(int rootid) {
		this.rootid = rootid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCont() {
		return cont;
	}
	
	public void setCont(String cont) {
		this.cont = cont;
	}
	
	public boolean isLeaf() {
		return isLeaf;
	}
	
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public Date getPdate() {
		return pdate;
	}
	
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	
	public void initFromRs(ResultSet rs) {
		try {
			this.setId(rs.getInt("id"));
			this.setPid(rs.getInt("pid"));
			this.setRootid(rs.getInt("rootid"));
			this.setTitle(rs.getString("title"));
			this.setCont(rs.getString("cont"));
			this.setLeaf(rs.getInt("isLeaf") == 0 ? true : false);
			this.setPdate(rs.getTimestamp("pdate"));
			this.setGrade(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
