package com.lk.spring.registration.dao;

import java.util.List;

import com.lk.spring.registration.model.User;

public interface UserDao {
	public void save(User u);
	public boolean userExists(User u);
	public List<User> getUsers();
}
