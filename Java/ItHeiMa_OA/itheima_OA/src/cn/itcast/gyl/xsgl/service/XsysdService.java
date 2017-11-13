package cn.itcast.gyl.xsgl.service;

import java.util.Set;

import cn.itcast.gyl.domain.xsgl.Xsysdzhib;
import cn.itcast.gyl.domain.xsgl.Xsysdzhub;
import cn.itcast.gyl.query.xsgl.XsysdzhubQuery;
import cn.itcast.gyl.service.base.BaseService;

public interface XsysdService extends BaseService<Xsysdzhub,Xsysdzhib>{
	public void saveXsysd(XsysdzhubQuery query_zhub,Set<Xsysdzhib> xsysdzhibs);
}
