package com.lk.spring.registration.service.impl;


import com.lk.spring.registration.service.UserService;
import com.lk.spring.registration.dao.UserDao;
import com.lk.spring.registration.dao.impl.UserDaoImpl;
import com.lk.spring.registration.model.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	
	public void add(User u) {
		userDao.save(u);
	}

	public boolean userExists(User u) {
		return userDao.userExists(u);
	}
	
}
