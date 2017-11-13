package cn.itcast.gyl.xsgl.service;

import java.util.Set;

import cn.itcast.gyl.domain.xsgl.Xsfhdzhib;
import cn.itcast.gyl.domain.xsgl.Xsfhdzhub;
import cn.itcast.gyl.query.xsgl.XsfhdzhubQuery;
import cn.itcast.gyl.service.base.BaseService;

public interface XsfhdService extends BaseService<Xsfhdzhub, Xsfhdzhib>{
	public void saveXsfhd(XsfhdzhubQuery query_zhub,Set<Xsfhdzhib> xsfhdzhibs);
}
