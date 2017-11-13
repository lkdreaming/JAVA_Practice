package com.lk.Spring.Registration.Service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.lk.Spring.Registration.model.User;
import com.lk.Spring.Registration.util.HibernateUtil;

public class UserService {
	
	public void add(User u) {
		
		SessionFactory sf = HibernateUtil.getSessFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}
	
	public boolean exists(User u) {
		
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
