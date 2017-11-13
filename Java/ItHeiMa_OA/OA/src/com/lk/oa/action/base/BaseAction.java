package com.lk.oa.action.base;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	public final static String LISTACTION = "listAction";
	public String listAction = LISTACTION;
	
	public final static String ADDUI = "addUI";
	public final String addUI = ADDUI;
	
	public final static String UPDATEUI = "updateUI";
	public final String updateUI = UPDATEUI
			;
	public final static String ACTION2ACTION = "Action2Action";
	public final String Action2Action = ACTION2ACTION;
	
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
}
