package com.lk.BBS2009.action;
import com.lk.BBS2009.model.Category;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class CategoryAction extends ActionSupport{
	List<Category> categories;
	
	public String list() {
		return SUCCESS;
	}
	
	public String add() {
		return SUCCESS;
	}
	
	public String update() {
		return SUCCESS;
	}
	
	public String delete() {
		return SUCCESS;
	}
	
	public String addInput() {
		return INPUT;
	}
	
	public String updateInput() {
		return INPUT;
	}
}
