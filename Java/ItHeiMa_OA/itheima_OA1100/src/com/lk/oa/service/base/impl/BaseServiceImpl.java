package com.lk.oa.service.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.lk.oa.dao.base.BaseDao;
import com.lk.oa.service.base.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	//private BaseDao<T> baseDao;
	/**
	 * 由子类来实现
	 * @return
	 */
	public abstract BaseDao<T> getBaseDao() ;
	@Override
	public List<T> getALLEntry() {
		return getBaseDao().getALLEntry();
	}

	@Override
	public T getEntryById(Serializable id) {
		return getBaseDao().getEntryById(id);
	}

	@Override
	public void updateEntry(T t) {
		getBaseDao().updateEntry(t);
		
	}

	@Override
	public void deleteEntry(Serializable id) {
		getBaseDao().deleteEntry(id);
		
	}

	@Override
	public void saveEntry(T t) {
		getBaseDao().saveEntry(t);
		
	}

	@Override
	public Set<T> getEntrysByIds(Serializable[] Serializables) {
		
		return getBaseDao().getEntrysByIds(Serializables);
	}

}
