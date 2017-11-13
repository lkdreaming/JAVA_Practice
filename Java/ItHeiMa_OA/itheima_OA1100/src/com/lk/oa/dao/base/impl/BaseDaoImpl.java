package com.lk.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
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
	/**
	 * 在该类的子类实例化之后,构造函数中获得泛型的实际类型,并复制给classT.
	 */
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		classT = (Class) type.getActualTypeArguments()[0];
	}
	
	/**
	 * 在初始化构造函数之后,紧接着获取到泛型参数T的元数据对象
	 */
	@PostConstruct
	public void init() {
		metaData = hibernateTemplate.getSessionFactory().getClassMetadata(classT);
	}
	
	
	@Override
	public List<T> getALLEntry() {
		return (List<T>)hibernateTemplate.find("from " + classT.getName());
	}

	@Override
	public T getEntryById(Serializable id) {
		return (T) hibernateTemplate.get(classT, id);
	}

	

	

	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void updateEntry(T t) {
		hibernateTemplate.update(t);
		
	}


	@Override
	public void saveEntry(T t) {
		System.out.println(classT.getName());
		hibernateTemplate.save(t);		
	}
	
	@Override
	public void deleteEntry(Serializable id) {
		T t = getEntryById(id);
		hibernateTemplate.delete(t);
		
	}


	@Override
	public Set<T> getEntrysByIds(Serializable[] serializables) {
		/**
		 * 拼接HQL语句
		 */
		String query = "from " + classT.getName();//from 对象
		query += " where " + metaData.getIdentifierPropertyName();// where 字段名(此处是ID)
		query += " in (";
		/**
		 * 遍历serializables数组中的值:如果是最后一个值不加逗号,如果不是则加逗号.
		 */
		for(int i = 0; i < serializables.length; i++) {
			if(i == serializables.length - 1) {
				query += serializables[i];
			}else {
				query += serializables[i] + ",";
			}
		}
		//加反括号,拼接HQL语句完成.
		query += ")";
		return new HashSet(hibernateTemplate.find(query));
	}


	

}
