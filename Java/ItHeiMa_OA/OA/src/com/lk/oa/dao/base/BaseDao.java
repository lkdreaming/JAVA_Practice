package com.lk.oa.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseDao<T> {
	/**
	 * 保存
	 * @param t
	 */
	void saveEntry(T t);
	/**
	 * 删除
	 * @param id
	 */
	void deleteEntryById(Serializable id);
	/**
	 * 查询所有
	 * @return
	 */
	List<T> getAllEntries();
	/**
	 * 用ID查询
	 * @param id
	 * @return
	 */
	T getEntryById(Serializable id);
	/**
	 * 用一组id查询对应的对象
	 * @param serializables
	 * @return
	 */
	Set<T> getEntriesByIds(Serializable[] serializables);
	/**
	 * 用对象查找对象
	 * @param map
	 * @return
	 */
	T queryEntryByProperty(Map<String, Object> map);
	/**
	 * 更新
	 * @param t
	 */
	void updateEntry(T t);
}
