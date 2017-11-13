package cn.itcast.gyl.domain.xsgl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 销售应收单主表
 * @author zd
 *
 */
public class Xsysdzhub implements Serializable{
	private Long xsysdzhubid;//主键
	private String ddh;
	private String gs;
	private Date rq;//日期
	private Date qsrq;//起算日期
	private String wldx;//往来对象
	private String ks;//客商
	private String bm;//部门
	private String ywy;//业务员
	private String sxbz;//生效标志
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String shr;//审核人
	private Date shrq;//审核日期
	private String qzr;//签字人
	private Date qzrq;//签字日期
	private String xgr;//修改人
	private Date xgrq;//修改日期
	
	private Set<Xsysdzhib> xsysdzhibs;
	
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public Set<Xsysdzhib> getXsysdzhibs() {
		return xsysdzhibs;
	}
	public void setXsysdzhibs(Set<Xsysdzhib> xsysdzhibs) {
		this.xsysdzhibs = xsysdzhibs;
	}
	public Long getXsysdzhubid() {
		return xsysdzhubid;
	}
	public void setXsysdzhubid(Long xsysdzhubid) {
		this.xsysdzhubid = xsysdzhubid;
	}
	
	public String getGs() {
		return gs;
	}
	public void setGs(String gs) {
		this.gs = gs;
	}
	public Date getRq() {
		return rq;
	}
	public void setRq(Date rq) {
		this.rq = rq;
	}
	public Date getQsrq() {
		return qsrq;
	}
	public void setQsrq(Date qsrq) {
		this.qsrq = qsrq;
	}
	public String getWldx() {
		return wldx;
	}
	public void setWldx(String wldx) {
		this.wldx = wldx;
	}
	public String getKs() {
		return ks;
	}
	public void setKs(String ks) {
		this.ks = ks;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getYwy() {
		return ywy;
	}
	public void setYwy(String ywy) {
		this.ywy = ywy;
	}
	public String getSxbz() {
		return sxbz;
	}
	public void setSxbz(String sxbz) {
		this.sxbz = sxbz;
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
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
	}
	public Date getShrq() {
		return shrq;
	}
	public void setShrq(Date shrq) {
		this.shrq = shrq;
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
}
