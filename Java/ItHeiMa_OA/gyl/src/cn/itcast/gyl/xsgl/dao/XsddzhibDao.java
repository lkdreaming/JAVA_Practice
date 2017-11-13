package cn.itcast.gyl.xsgl.dao;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsyddzhib;

public interface XsddzhibDao extends BaseDao<Xsddzhib>{
	/**
	 * 根据单据号,行号查询该单据号下的某一个销售订单子表的一行记录
	 * @param ddh
	 * @param hh
	 * @return
	 */
	public Xsddzhib getXsddzhib(String ddh,Long hh);
}
