package cn.itcast.gyl.query.xsgl;

import cn.itcast.gyl.query.BaseQuery;

public class XsfhdzhibQuery extends BaseQuery {
	private Long xsfhdzhubid;

	public Long getXsfhdzhubid() {
		return xsfhdzhubid;
	}
	public void setXsfhdzhubid(Long xsfhdzhubid) {
		this.xsfhdzhubid = xsfhdzhubid;
	}
	@Override
	protected void addWhere() {
		if (xsfhdzhubid != null) {
			addWhere("o.xsfhdzhub.xsfhdzhubid=?", this.xsfhdzhubid);
		}
	}
}
