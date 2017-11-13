package com.lk.spring.registration.service;

import java.util.List;

import com.lk.spring.registration.model.User;

public interface UserService {
	public void add(User u) ;
	public boolean userExists(User u);
	public List<User> getUsers();
}
