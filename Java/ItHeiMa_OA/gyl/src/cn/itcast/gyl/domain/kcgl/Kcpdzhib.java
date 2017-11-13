package cn.itcast.gyl.domain.kcgl;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存盘点子表
 * @author zd
 *
 */
public class Kcpdzhib implements Serializable{
	private Long kcpdzhibid;//主键
	private Long hh;//行号
	private String chbm;//存货编码
	private String chmc;//存货名称
	private String gg;//规格
	private String xh;//型号
	private String dw;//单位
	private String pc;//批次
	private Date scrq;//生产日期
	private Date sxrq;//失效日期
	private Long zmsl;//账面数量  系统数量
	private Long pdsl;//盘点数量
	private Long cysl;//差异数量
	private Long tzsl;//调整数量
	private Float ssl;//损失率  差异/系统数量
	
	private Kcpdzhub kcpdzhub;

	public Long getKcpdzhibid() {
		return kcpdzhibid;
	}

	public void setKcpdzhibid(Long kcpdzhibid) {
		this.kcpdzhibid = kcpdzhibid;
	}

	public Long getHh() {
		return hh;
	}

	public void setHh(Long hh) {
		this.hh = hh;
	}

	public String getChbm() {
		return chbm;
	}

	public void setChbm(String chbm) {
		this.chbm = chbm;
	}

	public String getChmc() {
		return chmc;
	}

	public void setChmc(String chmc) {
		this.chmc = chmc;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Date getScrq() {
		return scrq;
	}

	public void setScrq(Date scrq) {
		this.scrq = scrq;
	}

	public Date getSxrq() {
		return sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	public Long getZmsl() {
		return zmsl;
	}

	public void setZmsl(Long zmsl) {
		this.zmsl = zmsl;
	}

	public Long getPdsl() {
		return pdsl;
	}

	public void setPdsl(Long pdsl) {
		this.pdsl = pdsl;
	}

	public Long getCysl() {
		return cysl;
	}

	public void setCysl(Long cysl) {
		this.cysl = cysl;
	}

	public Long getTzsl() {
		return tzsl;
	}

	public void setTzsl(Long tzsl) {
		this.tzsl = tzsl;
	}

	public Float getSsl() {
		return ssl;
	}

	public void setSsl(Float ssl) {
		this.ssl = ssl;
	}

	public Kcpdzhub getKcpdzhub() {
		return kcpdzhub;
	}

	public void setKcpdzhub(Kcpdzhub kcpdzhub) {
		this.kcpdzhub = kcpdzhub;
	}
}
