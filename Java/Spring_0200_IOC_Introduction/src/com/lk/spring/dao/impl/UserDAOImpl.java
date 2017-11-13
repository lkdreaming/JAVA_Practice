package com.lk.spring.dao.impl;

import com.lk.spring.dao.UserDAO;
import com.lk.spring.model.User;

public class UserDAOImpl implements UserDAO {
	public void save(User user) {
		System.out.println("a user saved!!!");
	}
}
