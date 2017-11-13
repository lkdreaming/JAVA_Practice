package com.lk.spring.service;

import com.lk.spring.dao.UserDAO;
import com.lk.spring.model.User;

public class UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void add(User u) {
		userDAO.save(u);
	}
	
}
