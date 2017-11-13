package com.lk.spring.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.spring.model.User;

public class UserServiceTest {

	@Test
	public void testUserAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService) context.getBean("userService");
		User u = new User();
		u.setName("wangwu");
		userService.add(u);
	}

}
