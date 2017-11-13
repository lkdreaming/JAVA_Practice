package cn.itcast.gyl.query.xsgl;

import cn.itcast.gyl.query.BaseQuery;

public class XsyddzhibQuery extends BaseQuery {
	
	private Long xsyddzhubid;// 销售预订单主表ID
	
	public Long getXsyddzhubid() {
		return xsyddzhubid;
	}

	public void setXsyddzhubid(Long xsyddzhubid) {
		this.xsyddzhubid = xsyddzhubid;
	}

	@Override
	protected void addWhere() {
		if (xsyddzhubid != null) {
			addWhere("o.xsyddzhub.xsyddzhubid=?", this.xsyddzhubid);
		}
	}
}
