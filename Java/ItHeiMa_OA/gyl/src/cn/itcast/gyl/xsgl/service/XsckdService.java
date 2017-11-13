package cn.itcast.gyl.xsgl.service;

import java.util.Set;

import cn.itcast.gyl.domain.xsgl.Xsckdzhib;
import cn.itcast.gyl.domain.xsgl.Xsckdzhub;
import cn.itcast.gyl.query.xsgl.XsckdzhubQuery;
import cn.itcast.gyl.service.base.BaseService;

public interface XsckdService extends BaseService<Xsckdzhub, Xsckdzhib>{
	public void saveXsckd(XsckdzhubQuery query_zhub,Set<Xsckdzhib> xsckdzhibs);
}
