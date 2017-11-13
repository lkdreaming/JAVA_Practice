package com.lk.spring.registeration.action;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.spring.registration.action.UserAction;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		ua.setUsername("abc");
		ua.setPassword("abc");
		String ret = ua.execute();
		assertEquals("success", ret);
	}
	

}