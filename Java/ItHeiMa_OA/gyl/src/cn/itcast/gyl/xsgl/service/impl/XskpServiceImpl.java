package cn.itcast.gyl.xsgl.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhib;
import cn.itcast.gyl.domain.xsgl.Xskpzhib;
import cn.itcast.gyl.domain.xsgl.Xskpzhub;
import cn.itcast.gyl.query.xsgl.XskpzhubQuery;
import cn.itcast.gyl.service.base.impl.BaseServiceImpl;
import cn.itcast.gyl.utils.GylUtils;
import cn.itcast.gyl.xsgl.dao.XsddzhibDao;
import cn.itcast.gyl.xsgl.dao.XskpzhibDao;
import cn.itcast.gyl.xsgl.dao.XskpzhubDao;
import cn.itcast.gyl.xsgl.service.XskpService;

@Service("xskpService")
public class XskpServiceImpl extends BaseServiceImpl<Xskpzhub, Xskpzhib> implements XskpService{
	
	@Resource(name="xskpzhubDao")
	private XskpzhubDao xskpzhubDao;
	@Resource(name="xskpzhibDao")
	private XskpzhibDao xskpzhibDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xskpzhub> getDao_Zhu() {
		// TODO Auto-generated method stub
		return this.xskpzhubDao;
	}

	@Override
	public BaseDao<Xskpzhib> getDao_Zhi() {
		// TODO Auto-generated method stub
		return this.xskpzhibDao;
	}

	@Transactional(readOnly=false)
	public void saveXskp(XskpzhubQuery query_zhub, Set<Xskpzhib> xskpzhibs) {
		Xskpzhub xskpzhub = new Xskpzhub();
		/**
		 * 把页面上的内容复制到销售出库单的主表中
		 */
		BeanUtils.copyProperties(query_zhub, xskpzhub);
		xskpzhub.setXskpzhibs(xskpzhibs);
		/**
		 * 设置销售开票的发票号   按照订单号走
		 */
		Long id = xskpzhubDao.getMaxId();
		xskpzhub.setFph(GylUtils.ddH(id));
		for(Xskpzhib xskpzhib:xskpzhibs){
			/**
			 * Ytdjh  源头单据号  为销售订单的订单号
			 * Ythh   来源行号   为销售订单子表的行号
			 * 根据源头单据号和来源行号获取销售订单子表
			 */
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhib(xskpzhib.getYtdjh(), xskpzhib.getYthh());
			/**
			 * 每次出库的时候，都要把出库单的数量回写到销售订单子表中的累计出库数量
			 */
			xsddzhib.setLjkpsl(xsddzhib.getLjkpsl()+xskpzhib.getSl());
			if(xsddzhib.getLjkpsl()==xsddzhib.getSl()){//如果销售订单中的累计开票数量和销售订单中的数量一致，说明开票结束了
				xsddzhib.setIskpgb(true);//设置开票关闭
			}
		}
		this.xskpzhubDao.save(xskpzhub);
	}	
}
