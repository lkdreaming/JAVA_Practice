package cn.itcast.gyl.query.xsgl;

import cn.itcast.gyl.query.BaseQuery;

public class XsddzhibQuery extends BaseQuery {
	
	private Long xsddzhubid;// 销售订单主表ID
	
	private String hstatus;//行状态    "1"表示关闭   "2"表示未关闭
	

	public String getHstatus() {
		return hstatus;
	}
	public void setHstatus(String hstatus) {
		this.hstatus = hstatus;
	}
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
		if(hstatus != null){
			addWhere("o.hstatus=?",this.hstatus);
		}
	}
}
