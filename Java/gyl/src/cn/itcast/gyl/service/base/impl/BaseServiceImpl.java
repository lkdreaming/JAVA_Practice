package cn.itcast.gyl.service.base.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.query.BaseQuery;
import cn.itcast.gyl.query.PageResult;
import cn.itcast.gyl.service.base.BaseService;

public abstract class BaseServiceImpl<T,E extends Serializable> implements BaseService<T,E>{

	public abstract BaseDao<T> getDao_Zhu();
	public abstract BaseDao<E> getDao_Zhi();
	
	public PageResult<T> getEntityPageResult_Zhu(BaseQuery baseQuery){
		return this.getDao_Zhu().findPageResult(baseQuery);
	}
	public PageResult<E> getEntityPageResult_Zhi(BaseQuery baseQuery){
		return this.getDao_Zhi().findPageResult(baseQuery);
	}

	@Override
	public T getEntityById(Serializable id) {
		// TODO Auto-generated method stub
		return this.getDao_Zhu().get(id);
	}

	@Transactional(readOnly=false)
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		
		this.getDao_Zhu().save(t);
	}

	@Transactional(readOnly=false)
	public void updateEntry_Zhu(T t) {
		// TODO Auto-generated method stub
		this.getDao_Zhu().update(t);
	}
	
	@Transactional(readOnly=false)
	public void updateEntry_Zhi(E e) {
		// TODO Auto-generated method stub
		this.getDao_Zhi().update(e);
	}

	@Transactional(readOnly=false)
	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		this.getDao_Zhu().delete(id);
	}
	
	public T getEntity_Zhu(Serializable ddh){
		return this.getDao_Zhu().getEntry_Zhu(ddh);
	}
	
	public E getEntity_Zhi(Serializable hh){
		return this.getDao_Zhi().getEntry_Zhi(hh);
	}
	
	public Long getMaxId(){
		return this.getDao_Zhu().getMaxId();
	}
}
