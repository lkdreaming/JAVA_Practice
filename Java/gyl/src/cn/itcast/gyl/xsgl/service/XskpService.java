package cn.itcast.gyl.xsgl.service;

import java.util.Set;

import cn.itcast.gyl.domain.xsgl.Xskpzhib;
import cn.itcast.gyl.domain.xsgl.Xskpzhub;
import cn.itcast.gyl.query.xsgl.XskpzhubQuery;
import cn.itcast.gyl.service.base.BaseService;

public interface XskpService extends BaseService<Xskpzhub, Xskpzhib>{
	public void saveXskp(XskpzhubQuery query_zhub,Set<Xskpzhib> xskpzhibs);
}
