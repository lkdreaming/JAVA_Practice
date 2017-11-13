package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;
import java.util.Set;

/**
 * 采购订单主表
 * @author zd
 *
 */
public class Cgddzhub implements Serializable{
	private Long cgddzhubid;//主键
	private String gs;//公司
	private String ddh;//单据号
	private String gys;//供应商
	private String cgbm;//采购部门
	private String cgr;//采购人
	private Boolean isth;//是否退货
	private String jdr;//解冻人
	private String ddrq;//订单日期
	private String status;//状态
	private String bz;//币种
	private Float zdsl;//整单税率
	private Boolean djzt;//冻结状态
	
	private Set<Cgddzhib> cgddzhibs;
	
	public String getDdh() {
		return ddh;
	}

	public void setDdh(String ddh) {
		this.ddh = ddh;
	}

	public Long getCgddzhubid() {
		return cgddzhubid;
	}

	public void setCgddzhubid(Long cgddzhubid) {
		this.cgddzhubid = cgddzhubid;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
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

	public String getCgr() {
		return cgr;
	}

	public void setCgr(String cgr) {
		this.cgr = cgr;
	}

	public Boolean getIsth() {
		return isth;
	}

	public void setIsth(Boolean isth) {
		this.isth = isth;
	}

	public String getJdr() {
		return jdr;
	}

	public void setJdr(String jdr) {
		this.jdr = jdr;
	}

	public String getDdrq() {
		return ddrq;
	}

	public void setDdrq(String ddrq) {
		this.ddrq = ddrq;
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

	public Boolean getDjzt() {
		return djzt;
	}

	public void setDjzt(Boolean djzt) {
		this.djzt = djzt;
	}

	public Set<Cgddzhib> getCgddzhibs() {
		return cgddzhibs;
	}

	public void setCgddzhibs(Set<Cgddzhib> cgddzhibs) {
		this.cgddzhibs = cgddzhibs;
	}

}
