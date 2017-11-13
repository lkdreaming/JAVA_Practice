package cn.itcast.gyl.domain.xsgl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Xsddzhub implements Serializable {
	private Long xsddzhubid;// 主键
	private String ddh;// 订单号
	private Date dhrq;// 订货日期
	private Date sxrq;// 失效日期
	private String khmc;// 客户名称
	private Float zdkl;// 整单扣率
	private String sxbm;// 销售部门
	private String ywy;// 业务员
	private String kpdw;// 开票单位
	private String shdq;// 收货地区
	private String shdz;// 收货地址
	private String spr;// 审批人
	private Date sprq;// 审批日期
	private String zdr;// 制单人
	private Date zdrq;// 制单日期
	private String xgr;// 修改人
	private Date xgrq;// 修改日期
	private String state;// 状态
	private String lydjh;// 来源单据号 如果是正向的，那么来源单据号是销售预订单 如果是逆向的(退货单)，则是本身
	private String thbz;// 退货标志 1 代表退货 2代表不退货
	private String ckjsbz = "2";// 出库结束标志 1 代表出库结束 2代表没有出库结束
	private String kpjsbz = "2";// 开票结束标志 1 代表开票结束 2代表没有开票结束
	private String fhjsbz = "2";// 发货结束标志 1 代表发货结束 2代表没有发货结束
	private Float zdjshj;// 整单加税合计
	private Float sxkje;// 收现款金额

	private Set<Xsddzhib> xsddzhibs;

	public Float getZdjshj() {
		return zdjshj;
	}

	public void setZdjshj(Float zdjshj) {
		this.zdjshj = zdjshj;
	}

	public String getLydjh() {
		return lydjh;
	}

	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}

	public String getThbz() {
		return thbz;
	}

	public void setThbz(String thbz) {
		if (thbz == null) {
			this.thbz = "2";
		} else {
			this.thbz = thbz;
		}
	}

	public String getCkjsbz() {
		return ckjsbz;
	}

	public void setCkjsbz(String ckjsbz) {
		if (ckjsbz == null) {
			this.ckjsbz = "2";
		} else {
			this.ckjsbz = ckjsbz;
		}
	}

	public String getKpjsbz() {
		return kpjsbz;
	}

	public void setKpjsbz(String kpjsbz) {
		if (kpjsbz == null) {
			this.kpjsbz = "2";
		} else {
			this.kpjsbz = kpjsbz;
		}
	}

	public String getFhjsbz() {
		return fhjsbz;
	}

	public void setFhjsbz(String fhjsbz) {
		if (fhjsbz == null) {
			this.fhjsbz = "2";
		} else {
			this.fhjsbz = fhjsbz;
		}
	}

	public Long getXsddzhubid() {
		return xsddzhubid;
	}

	public void setXsddzhubid(Long xsddzhubid) {
		this.xsddzhubid = xsddzhubid;
	}

	public String getDdh() {
		return ddh;
	}

	public void setDdh(String ddh) {
		this.ddh = ddh;
	}

	public Date getDhrq() {
		return dhrq;
	}

	public void setDhrq(Date dhrq) {
		this.dhrq = dhrq;
	}

	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public Float getZdkl() {
		return zdkl;
	}

	public void setZdkl(Float zdkl) {
		this.zdkl = zdkl;
	}

	public String getSxbm() {
		return sxbm;
	}

	public void setSxbm(String sxbm) {
		this.sxbm = sxbm;
	}

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
	}

	public String getKpdw() {
		return kpdw;
	}

	public void setKpdw(String kpdw) {
		this.kpdw = kpdw;
	}

	public String getShdq() {
		return shdq;
	}

	public void setShdq(String shdq) {
		this.shdq = shdq;
	}

	public String getShdz() {
		return shdz;
	}

	public void setShdz(String shdz) {
		this.shdz = shdz;
	}

	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}

	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}

	public String getZdr() {
		return zdr;
	}

	public void setZdr(String zdr) {
		this.zdr = zdr;
	}

	public Date getZdrq() {
		return zdrq;
	}

	public void setZdrq(Date zdrq) {
		this.zdrq = zdrq;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public Date getXgrq() {
		return xgrq;
	}

	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Float getSxkje() {
		return sxkje;
	}

	public void setSxkje(Float sxkje) {
		this.sxkje = sxkje;
	}

	public Set<Xsddzhib> getXsddzhibs() {
		return xsddzhibs;
	}

	public void setXsddzhibs(Set<Xsddzhib> xsddzhibs) {
		this.xsddzhibs = xsddzhibs;
	}
}
