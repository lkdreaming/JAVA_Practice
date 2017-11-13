package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 采购发票主表
 * @author zd
 *
 */
public class Cgfpzhub implements Serializable{
	private Long cgfpzhubid;//主键
	private String gs;//公司
	private String fph;//发票号
	private String djzt;//单据状态
	private Date fprq;//发票日期
	private Date pdrq;//票到日期
	private String gys;//供应商
	private String cgbm;//采购部门
	private String fplx;//发票类型
	private String ywy;//业务员
	private String bz;//币种
	private Float zdsl;//整单税率
	private Boolean isycyf;//是否已传应付
	
	private Set<Cgfpzhib> cgfpzhibs;

	public Long getCgfpzhubid() {
		return cgfpzhubid;
	}

	public void setCgfpzhubid(Long cgfpzhubid) {
		this.cgfpzhubid = cgfpzhubid;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getFph() {
		return fph;
	}

	public void setFph(String fph) {
		this.fph = fph;
	}

	public String getDjzt() {
		return djzt;
	}

	public void setDjzt(String djzt) {
		this.djzt = djzt;
	}

	public Date getFprq() {
		return fprq;
	}

	public void setFprq(Date fprq) {
		this.fprq = fprq;
	}

	public Date getPdrq() {
		return pdrq;
	}

	public void setPdrq(Date pdrq) {
		this.pdrq = pdrq;
	}

	public String getGys() {
		return gys;
	}

	public void setGys(String gys) {
		this.gys = gys;
	}

	public String getCgbm() {
		return cgbm;
	}

	public void setCgbm(String cgbm) {
		this.cgbm = cgbm;
	}

	public String getFplx() {
		return fplx;
	}

	public void setFplx(String fplx) {
		this.fplx = fplx;
	}

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
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

	public Boolean getIsycyf() {
		return isycyf;
	}

	public void setIsycyf(Boolean isycyf) {
		this.isycyf = isycyf;
	}

	public Set<Cgfpzhib> getCgfpzhibs() {
		return cgfpzhibs;
	}

	public void setCgfpzhibs(Set<Cgfpzhib> cgfpzhibs) {
		this.cgfpzhibs = cgfpzhibs;
	}
}
