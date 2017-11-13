package com.lk.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lk.oa.dao.UserDao;
import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.model.User;
import com.lk.oa.service.UserService;
import com.lk.oa.service.base.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	private UserDao userDao;
	
	@Override
	public BaseDao getBaseDao() {
		return this.getUserDao();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
