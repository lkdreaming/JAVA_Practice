package com.lk.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.UserDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.User;
import com.lk.oa.service.UserService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

@Component("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	private UserDao userDao;
	
	@Override
	public BaseDao<User> getBaseDao() {
		return userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
