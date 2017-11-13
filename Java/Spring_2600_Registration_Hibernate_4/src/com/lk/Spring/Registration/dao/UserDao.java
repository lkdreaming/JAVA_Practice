package com.lk.Spring.Registration.dao;

import com.lk.Spring.Registration.model.User;

public interface UserDao {
	public void save(User u);
	public boolean userExists(User u);
}
