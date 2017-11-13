package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 采购入库单主表
 * @author zd
 *
 */
public class Cgrkdzhub implements Serializable{
	private Long cgrkdzhubid;//主键
	private String gs;//公司
	private String djh;//单据号
	private Date djrq;//单据日期
	private String ck;//仓库
	private String kgy;//库管员
	private String bm;//部门
	private String gys;//供应商
	private Boolean isth;//是否退货
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String spr;//审批人
	private Date sprq;//审批日期
	private String xgr;//修改人
	private Date xgrq;//修改日期
	
	private Set<Cgrkdzhib> cgrkdzhibs;

	public Long getCgrkdzhubid() {
		return cgrkdzhubid;
	}

	public void setCgrkdzhubid(Long cgrkdzhubid) {
		this.cgrkdzhubid = cgrkdzhubid;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getDjh() {
		return djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

	public Date getDjrq() {
		return djrq;
	}

	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}

	public String getCk() {
		return ck;
	}

	public void setCk(String ck) {
		this.ck = ck;
	}

	public String getKgy() {
		return kgy;
	}

	public void setKgy(String kgy) {
		this.kgy = kgy;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getGys() {
		return gys;
	}

	public void setGys(String gys) {
		this.gys = gys;
	}

	public Boolean getIsth() {
		return isth;
	}

	public void setIsth(Boolean isth) {
		this.isth = isth;
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

	public Set<Cgrkdzhib> getCgrkdzhibs() {
		return cgrkdzhibs;
	}

	public void setCgrkdzhibs(Set<Cgrkdzhib> cgrkdzhibs) {
		this.cgrkdzhibs = cgrkdzhibs;
	}
	
	
}
