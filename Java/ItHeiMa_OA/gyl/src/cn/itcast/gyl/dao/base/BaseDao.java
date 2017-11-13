package cn.itcast.gyl.dao.base;

import java.io.Serializable;
import java.util.List;

import cn.itcast.gyl.query.BaseQuery;
import cn.itcast.gyl.query.PageResult;
public interface BaseDao<T>{
	
	void save(T t);
	void update(T t);
	void delete(java.io.Serializable id);
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
	 * 根据行号提取子表中的数据
	 * 用于子表的修改
	 */
	T getEntry_Zhi(Serializable hh);
	
	/**
	 * @param hql 完整的hql语句. SELECT obj FROM User obj WHERE obj.name like ?
	 * @param params 查询参数 new Object[]{"%itcast_%"}
	 * @param start 查询起始行
	 * @param limit 查询返回最大条数
	 * @return
	 */
	List query(String hql,Object[] params,int start,int limit);
	List query(String hql,Object[] params);

	/**
	 * @param condition 查询条件 ,注意不要在前面加and  如：obj.name = ? and obj.password=?
	 * @param params 查询条件参数 new Object[]{"admin","123456"}
	 * @param start 查询起始行
	 * @param limit 查询返回最大条数
	 * @return
	 */
	List<T> queryEntity(String condition,Object[] params,int start,int limit);
	
	List<T> queryEntity(String condition,Object[] params);
	
	<E> E uniqueResult(String hql,Object[] params);
	
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	
	/**
	 * 获取订单主表中订单号的最后的一个的最大值
	 * @return
	 */
	public Long getMaxId();
}
