package com.lk.oa.service;

import java.util.Map;

import com.lk.oa.model.User;

public interface LoginService {
	//public User anthentication(User user) ;
	public User queryEntryByProperty(String username);
}
