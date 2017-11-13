package com.lk.spring.registration.service;


import com.lk.spring.registration.model.User;

public interface UserService {
	public void add(User u) ;
	public boolean userExists(User u);
	
}
