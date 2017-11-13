package cn.itcast.gyl.domain.kcgl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 库存期初主表
 * @author zd
 *
 */
public class Kcqczhub implements Serializable{
	private Long kcqczhubid;//主键
	private String gs;//公司
	private String djh;//单据号
	private Date djrq;//单据日期
	private String ck;//仓库
	private String kgy;//库管员
	private String bm;//部门
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String qzr;//签字人
	private Date qzrq;//签字日期
	private String xgr;//修改人
	private Date xgrq;//修改日期
	
	
	private Set<Kcqczhib> kcqczhibs;


	public Long getKcqczhubid() {
		return kcqczhubid;
	}


	public void setKcqczhubid(Long kcqczhubid) {
		this.kcqczhubid = kcqczhubid;
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


	public String getQzr() {
		return qzr;
	}


	public void setQzr(String qzr) {
		this.qzr = qzr;
	}


	public Date getQzrq() {
		return qzrq;
	}


	public void setQzrq(Date qzrq) {
		this.qzrq = qzrq;
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


	public Set<Kcqczhib> getKcqczhibs() {
		return kcqczhibs;
	}


	public void setKcqczhibs(Set<Kcqczhib> kcqczhibs) {
		this.kcqczhibs = kcqczhibs;
	}
}
