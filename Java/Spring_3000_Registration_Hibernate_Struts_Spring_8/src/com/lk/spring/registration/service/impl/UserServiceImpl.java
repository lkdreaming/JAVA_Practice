package com.lk.spring.registration.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.spring.registration.service.UserService;
import com.lk.spring.registration.dao.UserDao;
import com.lk.spring.registration.dao.impl.UserDaoImpl;
import com.lk.spring.registration.model.User;

@Component("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void add(User u) {
		userDao.save(u);
	}

	public boolean userExists(User u) {
		return userDao.userExists(u);
	}

	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
