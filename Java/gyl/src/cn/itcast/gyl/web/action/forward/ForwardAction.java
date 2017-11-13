package cn.itcast.gyl.web.action.forward;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport{
	private String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
	public String forward(){
		return this.method;
	}
}
