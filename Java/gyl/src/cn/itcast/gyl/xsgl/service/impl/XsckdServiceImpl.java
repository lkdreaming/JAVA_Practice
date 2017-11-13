package cn.itcast.gyl.xsgl.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.domain.xsgl.Xsckdzhib;
import cn.itcast.gyl.domain.xsgl.Xsckdzhub;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.query.xsgl.XsckdzhubQuery;
import cn.itcast.gyl.service.base.impl.BaseServiceImpl;
import cn.itcast.gyl.utils.GylUtils;
import cn.itcast.gyl.xsgl.dao.XsckdzhibDao;
import cn.itcast.gyl.xsgl.dao.XsckdzhubDao;
import cn.itcast.gyl.xsgl.dao.XsddzhibDao;
import cn.itcast.gyl.xsgl.service.XsckdService;

/**
 * 销售出库单
 * @author zd
 *
 */
@Service("xsckdService")
public class XsckdServiceImpl  extends BaseServiceImpl<Xsckdzhub, Xsckdzhib> implements XsckdService{
	@Resource(name="xsckdzhubDao")
	private XsckdzhubDao xsckdzhubDao;
	@Resource(name="xsckdzhibDao")
	private XsckdzhibDao xsckdzhibDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsckdzhub> getDao_Zhu() {
		// TODO Auto-generated method stub
		return xsckdzhubDao;
	}

	@Override
	public BaseDao<Xsckdzhib> getDao_Zhi() {
		// TODO Auto-generated method stub
		return xsckdzhibDao;
	}

	@Transactional(readOnly=false)
	public void saveXsckd(XsckdzhubQuery query_zhub,Set<Xsckdzhib> xsckdzhibs) {
		Xsckdzhub xsckdzhub = new Xsckdzhub();
		/**
		 * 把页面上的内容复制到销售出库单的主表中
		 */
		BeanUtils.copyProperties(query_zhub, xsckdzhub);
		/**
		 * 设置主表中的单据号
		 */
		Long id = this.xsckdzhubDao.getMaxId();
		xsckdzhub.setDdh(GylUtils.ddH(id));
		
		xsckdzhub.setXsckdzhibs(xsckdzhibs);
		for(Xsckdzhib xsckdzhib:xsckdzhibs){
			/**
			 * Ytdjh  源头单据号  为销售订单的订单号
			 * Ythh   来源行号   为销售订单子表的行号
			 * 根据源头单据号和来源行号获取销售订单子表
			 */
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhib(xsckdzhib.getYtdjh(), xsckdzhib.getYthh());
			/**
			 * 每次出库的时候，都要把出库单的数量回写到销售订单子表中的累计出库数量
			 */
			xsddzhib.setLjcksl(xsddzhib.getLjcksl()+xsckdzhib.getSfsl());
			if(xsddzhib.getLjcksl()==xsddzhib.getSl()){//检查销售订单中的子表中的某一个商品的累计出库数量是否和数量一样,如果一样,则出库关闭,如果不一样,则继续出库
				xsddzhib.setIsckgb(true);//设置出库关闭
			}
		}
		this.xsckdzhubDao.save(xsckdzhub);
	}
}
