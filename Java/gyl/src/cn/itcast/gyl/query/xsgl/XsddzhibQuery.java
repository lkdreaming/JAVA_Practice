package cn.itcast.gyl.query.xsgl;

import cn.itcast.gyl.query.BaseQuery;

public class XsddzhibQuery extends BaseQuery {
	
	private Long xsddzhubid;// 销售订单主表ID

	public Long getXsddzhubid() {
		return xsddzhubid;
	}
	public void setXsddzhubid(Long xsddzhubid) {
		this.xsddzhubid = xsddzhubid;
	}

	@Override
	protected void addWhere() {
		if (xsddzhubid != null) {
			addWhere("o.xsddzhub.xsddzhubid=?", this.xsddzhubid);
		}
	}
}
