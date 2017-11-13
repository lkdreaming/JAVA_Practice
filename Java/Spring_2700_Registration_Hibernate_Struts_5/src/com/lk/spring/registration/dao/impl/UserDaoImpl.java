package com.lk.spring.registration.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lk.spring.registration.dao.UserDao;
import com.lk.spring.registration.model.User;
import com.lk.spring.registration.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public void save(User u) {
		SessionFactory sf = HibernateUtil.getSessFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}

	public boolean userExists(User u) {
		SessionFactory sf = HibernateUtil.getSessFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from User u where u.username = :username")
				.setString("username", u.getUsername())
				.uniqueResult();
		s.getTransaction().commit();
		if (count > 0) return true;
		return false;
	}
	
}
