package com.lk.oa.dao.impl;

import org.springframework.stereotype.Component;
import com.lk.oa.dao.LoginDao;
import com.lk.oa.dao.base.impl.BaseDaoImpl;
import com.lk.oa.model.User;

@Component("loginDao")
public class LoginDaoImpl extends BaseDaoImpl<User> implements LoginDao {
	/*private HibernateTemplate hibernateTemplate;
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

	public User queryEntryByProperty(final Map<String, Object> map) {
		final StringBuffer sb = new StringBuffer();
		sb.append("from User");
		sb.append(" where 1=1");
		for(Entry<String, Object> entry : map.entrySet()) {
			sb.append(" and " + entry.getKey() + "=:" + entry.getKey());
		}
		System.out.println(sb.toString());
		return this.hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(sb.toString());
				for(Entry<String, Object> entry : map.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
				
				return (User) query.uniqueResult();
			}
		});
		
	}*/
}
