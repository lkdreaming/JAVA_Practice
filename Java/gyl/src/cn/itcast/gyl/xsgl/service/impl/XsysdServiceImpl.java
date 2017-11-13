package cn.itcast.gyl.xsgl.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.gyl.constant.GylConstantKey;
import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhib;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhub;
import cn.itcast.gyl.domain.xsgl.Xsysdzhib;
import cn.itcast.gyl.domain.xsgl.Xsysdzhub;
import cn.itcast.gyl.query.xsgl.XsysdzhubQuery;
import cn.itcast.gyl.service.base.impl.BaseServiceImpl;
import cn.itcast.gyl.utils.GylUtils;
import cn.itcast.gyl.xsgl.dao.XsddzhibDao;
import cn.itcast.gyl.xsgl.dao.XsysdzhibDao;
import cn.itcast.gyl.xsgl.dao.XsysdzhubDao;
import cn.itcast.gyl.xsgl.service.XsysdService;

/**
 * 销售应收单
 * @author zd
 *
 */
@Service("xsysdService")
public class XsysdServiceImpl extends BaseServiceImpl<Xsysdzhub,Xsysdzhib> implements XsysdService{
	
	@Resource(name="xsysdzhubDao")
	private XsysdzhubDao xsysdzhubDao;
	
	@Resource(name="xsysdzhibDao")
	private XsysdzhibDao xsysdzhibDao;
	
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;

	@Override
	public BaseDao<Xsysdzhub> getDao_Zhu() {
		// TODO Auto-generated method stub
		return this.xsysdzhubDao;
	}

	@Override
	public BaseDao<Xsysdzhib> getDao_Zhi() {
		// TODO Auto-generated method stub
		return this.xsysdzhibDao;
	}

	@Transactional(readOnly=false)
	public void saveXsysd(XsysdzhubQuery query_zhub, Set<Xsysdzhib> xsysdzhibs) {
		Xsysdzhub xsysdzhub = new Xsysdzhub();
		/**
		 * 把页面上的内容复制到销售出库单的主表中
		 */
		BeanUtils.copyProperties(query_zhub, xsysdzhub);
		xsysdzhub.setXsysdzhibs(xsysdzhibs);
		
		Long id = xsysdzhubDao.getMaxId();
		xsysdzhub.setDdh(GylUtils.ddH(id));
		
		for(Xsysdzhib xsysdzhib:xsysdzhibs){
			/**
			 * Ytdjh  源头单据号  为销售订单的订单号
			 * Ythh   来源行号   为销售订单子表的行号
			 * 根据源头单据号和来源行号获取销售订单子表
			 */
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhib(xsysdzhib.getYtdjh(), xsysdzhib.getYthh());
			
			xsddzhib.setLjyssl(xsddzhib.getLjyssl()+xsysdzhib.getSl());
			if(xsddzhib.getLjyssl()==xsddzhib.getSl()){//检查销售订单中的子表中的某一个商品的累计应收数量是否和数量一样,如果一样,则应收关闭,如果不一样,则继续应收
				xsddzhib.setIsskjs(true);//收款结束
				xsddzhib.setHstatus(GylConstantKey.HSTATUS_CLOUSE);//相应的行关闭
			}
		}
		this.xsysdzhubDao.save(xsysdzhub);
	}
}
