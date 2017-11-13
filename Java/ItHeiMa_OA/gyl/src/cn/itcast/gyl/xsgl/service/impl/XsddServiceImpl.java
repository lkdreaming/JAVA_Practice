package cn.itcast.gyl.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsddzhub;
import cn.itcast.gyl.service.base.impl.BaseServiceImpl;
import cn.itcast.gyl.xsgl.dao.XsddzhibDao;
import cn.itcast.gyl.xsgl.dao.XsddzhubDao;
import cn.itcast.gyl.xsgl.service.XsddService;

@Service("xsddService")
public class XsddServiceImpl extends BaseServiceImpl<Xsddzhub,Xsddzhib> implements XsddService{
	
	@Resource(name="xsddzhubDao")
	private XsddzhubDao xsddzhubDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsddzhub> getDao_Zhu() {
		// TODO Auto-generated method stub
		return this.xsddzhubDao;
	}
	@Override
	public BaseDao<Xsddzhib> getDao_Zhi() {
		// TODO Auto-generated method stub
		return this.xsddzhibDao;
	}
	
	@Override
	public void add_FromXsydd() {
		// TODO Auto-generated method stub
		
	}
}
