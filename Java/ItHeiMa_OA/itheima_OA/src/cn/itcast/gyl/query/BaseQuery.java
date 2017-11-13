package cn.itcast.gyl.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  抽象出来的公共的查询信息:当前页面，一页显示多少条数据,hql信息
 * @author zd
 *
 */
public abstract class BaseQuery {
	/**
	 * 当前页码，初始化的值为1
	 */
	private int currentPage = 1;

	/**
	 * 一页显示的条数
	 */
	private int pageSize = 2;
	/**
	 * 封装查询条件的hql语句，具体的查询条件来自于子类
	 */
	public StringBuilder builder = new StringBuilder();
	/**
	 * 封装查询条件参数的值
	 */
	private List params = new ArrayList();
	
	// 让子类必须重写,在里面先判断是否有条件,有添加条件
	protected abstract void addWhere();
	
	// 保证addWhere只能调用一次
	private boolean flag = false;
	
	protected void addWhere(String hql, Object... objects) {
		// 第2-n次的条件
		if (builder.length() > 0) {
			builder.append(" and ").append(hql);
		} else {
			builder.append(hql);
		}
		// 容易些错的地方:addAll,Arrays.asList
		params.addAll(Arrays.asList(objects));
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// 直接给BaseDao使用:o.username like ? and o.email like ?
	public String getWhere() {
			addWhere();
		return builder.toString();
	}

	// 直接给BaseDao使用: %admin%,%admin%
	public List getParams() {
		return params;
	}
}
