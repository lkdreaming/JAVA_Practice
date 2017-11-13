package com.lk.Spring.Registration.Service;

import com.lk.Spring.Registration.model.User;

public interface UserService {
	public void add(User u) ;
	public boolean userExists(User u);
}
