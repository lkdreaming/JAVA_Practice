package com.lk.oa.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport {
	private String method;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return method;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
