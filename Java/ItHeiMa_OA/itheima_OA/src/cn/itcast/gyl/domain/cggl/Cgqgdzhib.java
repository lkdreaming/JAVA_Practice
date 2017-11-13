package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;

/**
 * 采购请购单子表
 * @author zd
 *
 */
public class Cgqgdzhib implements Serializable{
	private Long cgqgdzhibid;//主键
	private Long hh;//行号
	private String spbm;//商品编码
	private String spmc;//商品名称
	private String gg;//规格
	private String dw;//单位 
	private String xh;//型号
	private Long sl;//数量
	private Float hsdj;//含税单价
	private Float wsdj;//无税单价
	private Float shuilv;//税率
	private Float hsje;//含税金额
	private Float wsje;//无税金额
	private Float se;//税额
	
	private Cgqgdzhub cgqgdzhub;

	public Long getCgqgdzhibid() {
		return cgqgdzhibid;
	}

	public void setCgqgdzhibid(Long cgqgdzhibid) {
		this.cgqgdzhibid = cgqgdzhibid;
	}

	public Long getHh() {
		return hh;
	}

	public void setHh(Long hh) {
		this.hh = hh;
	}

	public String getSpbm() {
		return spbm;
	}

	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public Float getHsdj() {
		return hsdj;
	}

	public void setHsdj(Float hsdj) {
		this.hsdj = hsdj;
	}

	public Float getWsdj() {
		return wsdj;
	}

	public void setWsdj(Float wsdj) {
		this.wsdj = wsdj;
	}

	public Float getShuilv() {
		return shuilv;
	}

	public void setShuilv(Float shuilv) {
		this.shuilv = shuilv;
	}

	public Float getHsje() {
		return hsje;
	}

	public void setHsje(Float hsje) {
		this.hsje = hsje;
	}

	public Float getWsje() {
		return wsje;
	}

	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}

	public Float getSe() {
		return se;
	}

	public void setSe(Float se) {
		this.se = se;
	}

	public Cgqgdzhub getCgqgdzhub() {
		return cgqgdzhub;
	}

	public void setCgqgdzhub(Cgqgdzhub cgqgdzhub) {
		this.cgqgdzhub = cgqgdzhub;
	}
	
	
}
