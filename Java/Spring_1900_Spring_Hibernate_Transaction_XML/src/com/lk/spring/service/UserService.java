package com.lk.spring.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.spring.dao.LogDAO;
import com.lk.spring.dao.UserDAO;
import com.lk.spring.model.Log;
import com.lk.spring.model.User;

@Component
public class UserService {
	private UserDAO userDAO;
	private LogDAO logDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void add(User user) {
		userDAO.save(user);
		Log log = new Log();
		log.setMsg("a user saved!!!!!");
		System.out.println(log.toString());
		logDAO.save(log);
		
	}
	public User getUser() {
		return null;
	}
	
	public LogDAO getLogDAO() {
		return logDAO;
	}
	@Resource
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}
}
