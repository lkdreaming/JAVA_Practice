package com.lk.oa.service.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.service.base.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	/**
	 * 需要什么类型的Dao让子类来提供
	 * @return
	 */
	public abstract BaseDao getBaseDao();
	
	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
	}

	public void deleteEntryById(Serializable id) {
		this.getBaseDao().deleteEntryById(id);
		
	}

	public List<T> getAllEntries() {
		return this.getBaseDao().getAllEntries();
	}

	public T getEntryById(Serializable id) {
		return (T) this.getBaseDao().getEntryById(id);
	}

	public Set<T> getEntriesByIds(Serializable[] serializables) {
		// TODO Auto-generated method stub
		return null;
	}

	public T queryEntryByProperty(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		
	}

	

}