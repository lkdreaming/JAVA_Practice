package com.lk.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	
	public String execute() throws Exception {
		
		return "sucess";
	}
	
	
	public String m1() {
		return "method1";
	}
	public String m2() {
		return "method2";
	}
}
