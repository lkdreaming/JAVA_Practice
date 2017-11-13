package cn.itcast.gyl.query.xsgl;

import cn.itcast.gyl.query.BaseQuery;

public class XsysdzhibQuery extends BaseQuery {
	
	private Long xsysdzhubid;

	public Long getXsysdzhubid() {
		return xsysdzhubid;
	}

	public void setXsysdzhubid(Long xsysdzhubid) {
		this.xsysdzhubid = xsysdzhubid;
	}

	@Override
	protected void addWhere() {
		if (xsysdzhubid != null) {
			addWhere("o.xsysdzhub.xsysdzhubid=?", this.xsysdzhubid);
		}
	}
}
