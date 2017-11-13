package com.lk.oa.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * crud的重用
 * @author Administrator
 *
 */
public interface BaseDao<T> {
	/**
	 * 查询所有对象
	 * @return
	 */
	public List<T> getALLEntry();
	/**
	 * 根据ID查询某一对象
	 * @param id
	 * @return
	 */
	public T getEntryById(Serializable id);
	/**
	 * 更新对象
	 * @param t
	 */
	public void updateEntry(T t);
	/**
	 * 根据ID删除对象
	 * @param id
	 */
	public void deleteEntry(Serializable id);
	/**
	 * 保存对象
	 * @param t
	 */
	public void saveEntry(T t);
	
	
	public  Set<T> getEntrysByIds(Serializable[] Serializables);
	public T queryEntryByProperty(final Map<String, Object> map);
}
