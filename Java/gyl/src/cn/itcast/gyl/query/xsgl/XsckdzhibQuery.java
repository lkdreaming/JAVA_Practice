package cn.itcast.gyl.query.xsgl;

import cn.itcast.gyl.query.BaseQuery;

public class XsckdzhibQuery extends BaseQuery {
	private Long xsckdzhubid;//主键
	
	public Long getXsckdzhubid() {
		return xsckdzhubid;
	}

	public void setXsckdzhubid(Long xsckdzhubid) {
		this.xsckdzhubid = xsckdzhubid;
	}

	@Override
	protected void addWhere() {
		if (xsckdzhubid != null) {
			addWhere("o.xsckdzhub.xsckdzhubid=?", this.xsckdzhubid);
		}
	}
}
