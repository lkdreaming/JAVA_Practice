package com.lk.spring.registration.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.lk.spring.registration.dao.UserDao;
import com.lk.spring.registration.model.User;
import com.lk.spring.registration.util.HibernateUtil;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	HibernateTemplate hibernateTemplate;
	public void save(User u) {
		hibernateTemplate.save(u);
	}

	public boolean userExists(User u) {
		List<User> users = hibernateTemplate.find("from User u where u.username='" + u.getUsername() + "'");
		if(users != null && users.size() > 0) return true;
		return false;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
