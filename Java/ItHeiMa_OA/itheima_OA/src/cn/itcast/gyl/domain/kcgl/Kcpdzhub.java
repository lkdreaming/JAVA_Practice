package cn.itcast.gyl.domain.kcgl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 库存盘点主表
 * @author zd
 *
 */
public class Kcpdzhub implements Serializable{
	private Long kcpdzhubid;//主键
	private String gs;//公司
	private String djh;//单据号
	private Date djrq;//单据日期
	private Date pdrq;//盘点日期
	private String ck;//仓库
	private String kgy;//库管员
	private String bm;//部门
	private String pdr;//盘点人
	private String status;//单据状态  需要审批  不审批不会影响存量，不审批不能对数据库改变
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String spr;//审批人
	private Date sprq;//审批日期
	private String xgr;//修改人  能对所有的字段进行修改
	private Date xgrq;//修改日期
	private String tzr;//调整人
	private Date tzrq;//调整日期
	
	private Set<Kcpdzhib> kcpdzhibs;

	public Long getKcpdzhubid() {
		return kcpdzhubid;
	}

	public void setKcpdzhubid(Long kcpdzhubid) {
		this.kcpdzhubid = kcpdzhubid;
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

	public Date getPdrq() {
		return pdrq;
	}

	public void setPdrq(Date pdrq) {
		this.pdrq = pdrq;
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

	public String getPdr() {
		return pdr;
	}

	public void setPdr(String pdr) {
		this.pdr = pdr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTzr() {
		return tzr;
	}

	public void setTzr(String tzr) {
		this.tzr = tzr;
	}

	public Date getTzrq() {
		return tzrq;
	}

	public void setTzrq(Date tzrq) {
		this.tzrq = tzrq;
	}

	public Set<Kcpdzhib> getKcpdzhibs() {
		return kcpdzhibs;
	}

	public void setKcpdzhibs(Set<Kcpdzhib> kcpdzhibs) {
		this.kcpdzhibs = kcpdzhibs;
	}
}
