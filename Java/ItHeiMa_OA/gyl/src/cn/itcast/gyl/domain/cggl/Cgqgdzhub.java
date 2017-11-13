package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 采购请购单主表
 * @author zd
 *
 */
public class Cgqgdzhub implements Serializable{
	private Long cgqgdzhubid;//主键
	private String gs;//公司
	private String djh;//单据号
	private String qggys;//请购供应商
	private String cgbm;//采购部门
	private String cgr;//采购人
	private Date qgrq;//请购日期
	private String status;//状态  自由  审批中 通过 未通过
	private String bz;//币种
	private Float zdsl;//整单税率
	
	private Set<Cgqgdzhib> cgqgdzhibs;//采购请购单子表

	public Long getCgqgdzhubid() {
		return cgqgdzhubid;
	}

	public void setCgqgdzhubid(Long cgqgdzhubid) {
		this.cgqgdzhubid = cgqgdzhubid;
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

	public String getQggys() {
		return qggys;
	}

	public void setQggys(String qggys) {
		this.qggys = qggys;
	}

	public String getCgbm() {
		return cgbm;
	}

	public void setCgbm(String cgbm) {
		this.cgbm = cgbm;
	}

	public String getCgr() {
		return cgr;
	}

	public void setCgr(String cgr) {
		this.cgr = cgr;
	}

	public Date getQgrq() {
		return qgrq;
	}

	public void setQgrq(Date qgrq) {
		this.qgrq = qgrq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Float getZdsl() {
		return zdsl;
	}

	public void setZdsl(Float zdsl) {
		this.zdsl = zdsl;
	}

	public Set<Cgqgdzhib> getCgqgdzhibs() {
		return cgqgdzhibs;
	}

	public void setCgqgdzhibs(Set<Cgqgdzhib> cgqgdzhibs) {
		this.cgqgdzhibs = cgqgdzhibs;
	}
	
	
}
