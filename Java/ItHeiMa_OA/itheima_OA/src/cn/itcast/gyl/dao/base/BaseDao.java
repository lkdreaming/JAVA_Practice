package cn.itcast.gyl.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import cn.itcast.gyl.query.BaseQuery;
import cn.itcast.gyl.query.PageResult;
public interface BaseDao<T>{
	void save(T t);
	void update(T t);
	void delete(java.io.Serializable id);
	void deleteByIds(Serializable[] ids);
	/**
	 * 根据id提取一个持久化bean的数据
	 * @param id
	 * @return
	 */
	T get(java.io.Serializable id);
	/**
	 * 根据订单号提取主表中的数据
	 * 用于主表的修改
	 * @param ddh
	 * @return
	 */
	T getEntry_Zhu(Serializable ddh);
	/**
	 * 根据订单号和订单状态查询主表
	 *   ddh 代表订单号
	 *   status  代表订单状态
	 *   查询的是未完成的订单,用于修改环节
	 */
	T getEntry_Zhu(String ddh,String status);
	/**
	 * 根据行号提取子表中的数据
	 * 用于子表的修改
	 */
	T getEntry_Zhi(String zhubName,Serializable hh,String ddh);
	Set<T> getEntriesByIds(Serializable[] ids);
	public Collection<T> getAllEntry();
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	/**
	 * 获取订单主表中订单号的最后的一个的最大值
	 * @return
	 */
	public Long getMaxId();
}
