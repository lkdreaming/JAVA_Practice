package com.lk.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lk.oa.dao.LoginDao;
import com.lk.oa.model.User;
import com.lk.oa.service.LoginService;

@Component("loginService")
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	@Override
	public User anthentication(User user) {
		return loginDao.authentication(user);
	}
	public LoginDao getLoginDao() {
		return loginDao;
	}
	
	@Resource(name = "loginDao")
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
