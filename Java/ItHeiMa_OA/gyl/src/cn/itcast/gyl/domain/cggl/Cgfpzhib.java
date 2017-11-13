package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;

/**
 * 采购发票子表
 * @author zd
 *
 */
public class Cgfpzhib implements Serializable{
	private Long cgfpzhibid;//主键
	private Long hh;//行号
	private String chbm;//存货编码
	private String chmc;//存货名称
	private String xh;//型号
	private Float wsdj;//无税单价
	private String pc;//批次
	private Long fpsl;//发票数量
	private Float je;//金额
	private String bz;//币种
	private Float hsdj;//含税单价
	private Float sl;//税率
	private Float se;//税额
	private Float wsje;//无税金额
	private String lydjh;//来源单据号  订单或者入库单
	private String lyhh;//来源行号        订单或者入库单
	private String ytdjd;//源头单据号
	private String ythh;//源头行号
	
	private Cgfpzhub cgfpzhub;

	public Long getCgfpzhibid() {
		return cgfpzhibid;
	}

	public void setCgfpzhibid(Long cgfpzhibid) {
		this.cgfpzhibid = cgfpzhibid;
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

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public Float getWsdj() {
		return wsdj;
	}

	public void setWsdj(Float wsdj) {
		this.wsdj = wsdj;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Long getFpsl() {
		return fpsl;
	}

	public void setFpsl(Long fpsl) {
		this.fpsl = fpsl;
	}

	public Float getJe() {
		return je;
	}

	public void setJe(Float je) {
		this.je = je;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Float getHsdj() {
		return hsdj;
	}

	public void setHsdj(Float hsdj) {
		this.hsdj = hsdj;
	}

	public Float getSl() {
		return sl;
	}

	public void setSl(Float sl) {
		this.sl = sl;
	}

	public Float getSe() {
		return se;
	}

	public void setSe(Float se) {
		this.se = se;
	}

	public Float getWsje() {
		return wsje;
	}

	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}

	public String getLydjh() {
		return lydjh;
	}

	public void setLydjh(String lydjh) {
		this.lydjh = lydjh;
	}

	public String getLyhh() {
		return lyhh;
	}

	public void setLyhh(String lyhh) {
		this.lyhh = lyhh;
	}

	public String getYtdjd() {
		return ytdjd;
	}

	public void setYtdjd(String ytdjd) {
		this.ytdjd = ytdjd;
	}

	public String getYthh() {
		return ythh;
	}

	public void setYthh(String ythh) {
		this.ythh = ythh;
	}

	public Cgfpzhub getCgfpzhub() {
		return cgfpzhub;
	}

	public void setCgfpzhub(Cgfpzhub cgfpzhub) {
		this.cgfpzhub = cgfpzhub;
	}
}
