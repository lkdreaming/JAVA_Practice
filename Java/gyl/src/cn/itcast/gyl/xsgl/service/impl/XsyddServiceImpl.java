package cn.itcast.gyl.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.gyl.dao.base.BaseDao;
import cn.itcast.gyl.domain.xsgl.Xsyddzhib;
import cn.itcast.gyl.domain.xsgl.Xsyddzhub;
import cn.itcast.gyl.service.base.impl.BaseServiceImpl;
import cn.itcast.gyl.xsgl.dao.XsyddzhibDao;
import cn.itcast.gyl.xsgl.dao.XsyddzhubDao;
import cn.itcast.gyl.xsgl.service.XsyddService;

@Service("xsyddService")
public class XsyddServiceImpl extends BaseServiceImpl<Xsyddzhub,Xsyddzhib> implements XsyddService{
	
	@Resource(name="xsyddzhubDao")
	private XsyddzhubDao xsyddzhubDao;
	
	@Resource(name="xsyddzhibDao")
	private XsyddzhibDao xsyddzhibDao;

	@Override
	public BaseDao<Xsyddzhub> getDao_Zhu() {
		// TODO Auto-generated method stub
		return this.xsyddzhubDao;
	}

	@Override
	public BaseDao<Xsyddzhib> getDao_Zhi() {
		// TODO Auto-generated method stub
		return this.xsyddzhibDao;
	}
}
