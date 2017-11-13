package com.lk.spring.registration.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lk.spring.registration.model.User;
import com.lk.spring.registration.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Component("user")
public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private String passwordc;
	private UserService us;
	List<User> users;
	
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

	public UserService getUs() {
		return us;
	}
	@Resource(name="userService")
	public void setUs(UserService us) {
		this.us = us;
	}
	
	public String list() {
		 this.users = this.us.getUsers();
		 return "list";
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
