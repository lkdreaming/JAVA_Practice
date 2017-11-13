package com.lk.spring.registeration.action;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.spring.registration.action.UserAction;
import com.lk.spring.registration.model.User;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		ua.setUsername("abc");
		ua.setPassword("abc");
		String ret = ua.execute();
		assertEquals("success", ret);
	}

	
	@Test
	public void TestGetUsers() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserAction ua = (UserAction) ctx.getBean("user");
		ua.list();
		List<User> users = ua.getUsers();
		Iterator<User> it = users.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getUsername());
			
		}
		Assert.assertTrue(users.size() > 0);
	}
}
