package com.lk.oa.dao.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.lk.oa.dao.LoginDao;
import com.lk.oa.model.User;

@Component("loginDao")
public class LoginDaoImpl implements LoginDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public User authentication(final User user) {
		return this.hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from User where username = :username and password = :password");
				query.setString("username", user.getUsername());
				query.setString("password", user.getPassword());
				return (User) query.uniqueResult();
			}
			
		});
	}

}
