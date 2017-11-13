package com.lk.oa.dao;


import com.lk.oa.model.User;


public interface LoginDao {
	public User authentication(final User user);
}
