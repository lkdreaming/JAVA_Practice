package cn.itcast.gyl.xsgl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.gyl.dao.base.impl.BaseDaoImpl;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsyddzhib;
import cn.itcast.gyl.xsgl.dao.XsddzhibDao;
import cn.itcast.gyl.xsgl.dao.XsyddzhibDao;

@Repository("xsddzhibDao")
public class XsddzhibDaoImpl extends BaseDaoImpl<Xsddzhib> implements XsddzhibDao{
	/**
	 * 根据单据号,行号查询该单据号下的某一个销售订单子表的一行记录
	 */
	@Override
	public Xsddzhib getXsddzhib(String ddh, Long hh) {
		// TODO Auto-generated method stub
		return (Xsddzhib)this.hibernateTemplate.find("from Xsddzhib where hh=? and xsddzhub.ddh=?",hh,ddh).get(0);
	}
}
