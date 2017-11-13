package com.lk.spring.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.lk.spring.dao.UserDAO;
import com.lk.spring.model.User;

@Component
public class UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void add(User user) {
		userDAO.save(user);
	}
	
}
