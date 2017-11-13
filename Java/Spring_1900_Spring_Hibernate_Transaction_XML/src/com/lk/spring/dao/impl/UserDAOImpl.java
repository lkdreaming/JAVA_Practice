package com.lk.spring.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.lk.spring.dao.UserDAO;
import com.lk.spring.model.User;
@Component("userDAO")
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void save(User user) {
		Session s = sessionFactory.getCurrentSession();
		s.save(user);
	}
}
