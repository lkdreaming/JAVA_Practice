package cn.itcast.gyl.domain.xsgl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 销售出库单主表
 * @author zd
 *
 */
public class Xsfhdzhub implements Serializable{
	private Long xsfhdzhubid;//主键
	private String ddh;//单据号
	private String gs;//公司
	private Date djrq;//单据日期
	private String ck;//仓库
	private String kgy;//库管员
	private String bm;//部门
	private String kh;//客户
	private Boolean isth;//是否退货
	private String status;//单据状态
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String shr;//审核人
	private Date shrq;//审核日期
	private String qzr;//签字人
	private Date xgrq;//修改日期
	private Set<Xsfhdzhib> xsfhdzhibs; //销售出库单子表
	
	
	
	public Set<Xsfhdzhib> getXsfhdzhibs() {
		return xsfhdzhibs;
	}
	public void setXsfhdzhibs(Set<Xsfhdzhib> xsfhdzhibs) {
		this.xsfhdzhibs = xsfhdzhibs;
	}
	public Long getXsfhdzhubid() {
		return xsfhdzhubid;
	}
	public void setXsfhdzhubid(Long xsfhdzhubid) {
		this.xsfhdzhubid = xsfhdzhubid;
	}
	
	
	
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getGs() {
		return gs;
	}
	public void setGs(String gs) {
		this.gs = gs;
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
	public String getKh() {
		return kh;
	}
	public void setKh(String kh) {
		this.kh = kh;
	}
	public Boolean getIsth() {
		return isth;
	}
	public void setIsth(Boolean isth) {
		this.isth = isth;
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
	public Date getXgrq() {
		return xgrq;
	}
	public void setXgrq(Date xgrq) {
		this.xgrq = xgrq;
	}
}
