package cn.itcast.gyl.query.xsgl;

import cn.itcast.gyl.query.BaseQuery;

/**
 * 销售开票子表
 * @author zd
 *
 */
public class XskpzhibQuery extends BaseQuery {
	private Long xskpzhubid;
	
	public Long getXskpzhubid() {
		return xskpzhubid;
	}

	public void setXskpzhubid(Long xskpzhubid) {
		this.xskpzhubid = xskpzhubid;
	}

	@Override
	protected void addWhere() {
		if (xskpzhubid != null) {
			addWhere("o.xskpzhub.xskpzhubid=?", this.xskpzhubid);
		}
	}
}
