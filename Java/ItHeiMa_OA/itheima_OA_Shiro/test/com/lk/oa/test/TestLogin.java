package com.lk.oa.test;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.dao.impl.LoginDaoImpl;
import com.lk.oa.model.User;
import com.lk.oa.service.LoginService;

public class TestLogin {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	LoginService ls = (LoginService) ctx.getBean("loginService");
	@Test
	public void test() {
		
		User user = ls.queryEntryByProperty("admin");
		if(user != null) {
			System.out.println(user.getUsername() + "," + user.getPassword());
		} else {
			System.out.println("该user不存在");
		}
		
	}

}
