package com.lk.Spring.Registration.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lk.Spring.Registration.dao.UserDao;
import com.lk.Spring.Registration.model.User;
import com.lk.Spring.Registration.util.HibernateUtil;

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
