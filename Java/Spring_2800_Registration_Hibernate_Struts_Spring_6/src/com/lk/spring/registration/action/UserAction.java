package com.lk.spring.registration.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.spring.registration.model.User;
import com.lk.spring.registration.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private String passwordc;
	UserService us;
	public UserAction() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//UserService ����new������ �Ǵ�spring�е� applicationContext�� ��getBean()ȡ������
		us = (UserService) ctx.getBean("userService");
	}
	
	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		if(us.userExists(u)) return "fail";
		else {
			us.add(u);
			return "success";
		}
		
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPasswordc() {
		return passwordc;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordc(String passwordc) {
		this.passwordc = passwordc;
	}
}