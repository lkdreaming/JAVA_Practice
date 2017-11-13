

package cn.itcast.gyl.service.base;

import java.io.Serializable;

import cn.itcast.gyl.query.BaseQuery;
import cn.itcast.gyl.query.PageResult;

public interface BaseService<T,E extends Serializable>{
	public PageResult<T> getEntityPageResult_Zhu(BaseQuery baseQuery);
	public PageResult<E> getEntityPageResult_Zhi(BaseQuery baseQuery);
	public T getEntityById(Serializable id);
	/**
	 * 根据订单号查询主表
	 * @param ddh
	 * @return
	 */
	public T getEntity_Zhu(Serializable ddh);
	
	/**
	 * 根据订单号和订单状态查询主表
	 *   ddh 代表订单号
	 *   status  代表订单状态
	 *   查询的是未完成的订单,用于修改环节
	 */
	T getEntry_Zhu(String ddh,String status);
	
	
	/**
	 * 根据行号查询子表
	 * @param hh
	 * @return
	 */
	public E getEntity_Zhi(String zhubName,Serializable hh,String ddh);
	
	public void saveEntry(T t);
	public void updateEntry_Zhu(T t);
	public void updateEntry_Zhi(E e);
	public void deleteEntry(Serializable id);
	
	/**
	 * 获取主表中主键的最大值
	 * @return
	 */
	public Long getMaxId();
}
