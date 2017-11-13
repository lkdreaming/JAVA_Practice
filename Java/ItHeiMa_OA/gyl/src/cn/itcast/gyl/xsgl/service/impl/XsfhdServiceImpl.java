package cn.itcast.gyl.xsgl.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhib;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhub;
import cn.itcast.gyl.query.xsgl.XsfhdzhubQuery;
import cn.itcast.gyl.service.base.impl.BaseServiceImpl;
import cn.itcast.gyl.utils.GylUtils;
import cn.itcast.gyl.xsgl.dao.XsddzhibDao;
import cn.itcast.gyl.xsgl.dao.XsfhdzhibDao;
import cn.itcast.gyl.xsgl.dao.XsfhdzhubDao;
import cn.itcast.gyl.xsgl.service.XsfhdService;

@Service("xsfhdService")
public class XsfhdServiceImpl extends BaseServiceImpl<Xsfhdzhub, Xsfhdzhib> implements XsfhdService{
	
	@Resource(name="xsfhdzhubDao")
	private XsfhdzhubDao xsfhdzhubDao;
	
	@Resource(name="xsfhdzhibDao")
	private XsfhdzhibDao xsfhdzhibDao;

	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsfhdzhub> getDao_Zhu() {
		// TODO Auto-generated method stub
		return this.xsfhdzhubDao;
	}

	@Override
	public BaseDao<Xsfhdzhib> getDao_Zhi() {
		// TODO Auto-generated method stub
		return this.xsfhdzhibDao;
	}

	@Transactional(readOnly=false)
	public void saveXsfhd(XsfhdzhubQuery query_zhub, Set<Xsfhdzhib> xsfhdzhibs) {
		Xsfhdzhub xsfhdzhub = new Xsfhdzhub();
		/**
		 * 把页面上的内容复制到销售出库单的主表中
		 */
		BeanUtils.copyProperties(query_zhub, xsfhdzhub);
		/*
		 * 创建销售发货单的主表的订单号
		 */
		//获取销售发货单主表的最新的主键值
		Long id = this.xsfhdzhubDao.getMaxId();
		//设置订单号
		xsfhdzhub.setDdh(GylUtils.ddH(id));
		xsfhdzhub.setXsfhdzhibs(xsfhdzhibs);
		for(Xsfhdzhib xsfhdzhib:xsfhdzhibs){
			/**
			 * Ytdjh  源头单据号  为销售订单的订单号
			 * Ythh   来源行号   为销售订单子表的行号
			 * 根据源头单据号和来源行号获取销售订单子表
			 */
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhib(xsfhdzhib.getYtdjh(), xsfhdzhib.getYthh());
			/**
			 * 每次出库的时候，都要把出库单的数量回写到销售订单子表中的累计出库数量
			 */
			xsddzhib.setLjfhsl(xsddzhib.getLjfhsl()+xsfhdzhib.getSfsl());
			if(xsddzhib.getLjfhsl()==xsddzhib.getSl()){//检查销售订单中的子表中的某一个商品的累计出库数量是否和数量一样,如果一样,则出库关闭,如果不一样,则继续出库
				xsddzhib.setIsfhgb(true);//设置出库关闭
			}
		}
		this.xsfhdzhubDao.save(xsfhdzhub);
	}

}
