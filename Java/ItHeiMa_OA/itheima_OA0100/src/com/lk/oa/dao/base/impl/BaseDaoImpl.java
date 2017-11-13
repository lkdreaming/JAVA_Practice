package com.lk.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.lk.oa.dao.base.BaseDao;


public class BaseDaoImpl<T> implements BaseDao<T> {
	private HibernateTemplate hibernateTemplate;
	//代表T的实际类型
	private Class classT;
	private ClassMetadata metaData;
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classT = (Class) type.getActualTypeArguments()[0];
	}
	
	/**
	 * 获取到泛型参数T的元数据对象
	 */
	@PostConstruct
	public void init() {
		metaData = hibernateTemplate.getSessionFactory().getClassMetadata(classT);
	}
	
	
	@Override
	public List<T> getALLEntry() {
		return (List<T>)hibernateTemplate.find("from" + classT.getName());
	}

	@Override
	public T getEntryById(Serializable id) {
		return (T) hibernateTemplate.get(classT, id);
	}

	

	

	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void updateEntry(T t) {
		hibernateTemplate.update(t);
		
	}


	@Override
	public void saveEntry(T t) {
		hibernateTemplate.save(t);		
	}
	
	@Override
	public void deleteEntry(Serializable id) {
		hibernateTemplate.delete(id);
		
	}


	@Override
	public Set<T> getEntrysByIds(Serializable[] serializables) {
		String query = "from" + classT.getName();
		query += " where " + metaData.getIdentifierPropertyName();
		query += " in (";
		for(int i = 0; i < serializables.length; i++) {
			if(i == serializables.length - 1) {
				query += serializables[i];
			}else {
				query += serializables[i] + ",";
			}
		}
		query += ")";
		return null;
	}


	

}
