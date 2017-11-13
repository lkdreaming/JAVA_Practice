package com.lk.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.lk.oa.dao.base.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private HibernateTemplate hibernateTemplate;
	private ClassMetadata metadata;
	private Class classT;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classT = (Class) type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init() {
		this.metadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(classT);
	}
	
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	public void deleteEntryById(Serializable id) {
		this.hibernateTemplate.delete(this.getEntryById(id));
	}

	public List<T> getAllEntries() {
		return (List<T>) this.hibernateTemplate.find("from " + this.classT.getName());
	}

	public T getEntryById(Serializable id) {
		return (T) this.hibernateTemplate.get(this.classT, id);
	}

	public Set<T> getEntriesByIds(Serializable[] serializables) {
		StringBuffer sb = new StringBuffer();
		sb.append("from " + this.classT.getName() + " where ");
		sb.append(this.metadata.getIdentifierPropertyName() + " in (");
		for (int i = 0; i < serializables.length; i++) {
			if(i == serializables.length - 1) {
				sb.append(serializables[i]);
			}	
			else {
				sb.append(serializables[i] + ",");
			}	
		}
		sb.append(")");
		return (Set<T>) this.hibernateTemplate.find(sb.toString());
	}

	public T queryEntryByProperty(final Map<String, Object> map) {
		final StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(" from " + this.classT.getName() + " where 1=1");
		for(Entry<String, Object> entry : map.entrySet()) {
			stringBuffer.append(" and " + entry.getKey() + "=:" + entry.getKey());
		}
		return this.hibernateTemplate.execute(new HibernateCallback<T>() {

			public T doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(stringBuffer.toString());
				for(Entry<String, Object> entry : map.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
				
				return (T) query.uniqueResult();
			}
		});
	}

	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
