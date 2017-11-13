package com.lk.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.lk.spring.dao.UserDAO;
import com.lk.spring.model.User;
@Component("u1")
public class UserDAOImpl implements UserDAO {
	public void save(User user) {
		System.out.println("a user saved!!!");
	}
}
