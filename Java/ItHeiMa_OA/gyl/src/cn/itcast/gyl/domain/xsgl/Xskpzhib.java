package cn.itcast.gyl.domain.xsgl;

import java.io.Serializable;

/**
 * 销售开票子表
 * @author zd
 *
 */
public class Xskpzhib implements Serializable{
	private Long xskpzhibid;//主键
	private Long hh;//行号
	private String spbm;//商品编码
	private String spmc;//商品名称
	private String dw;//单位
	private String xh;//型号
	private Long sl;//数量
	private Float dpkl;//单品扣率
	private Float shulv;//税率
	private Float hsdj;//含税单价
	private Float wsdj;//无税单价
	private Float hsje;//含税金额
	private Float wsje;//无税金额
	private Float zke;//折扣额
	private String ytdjh;//源头单据号
	private Long ythh;//源头行号
	private String lydjh;//来源单据号
	private String lyhh;//来源行号
	private String zp;//赠品
	private String ck;//仓库
	private String shdw;//收货单位
	private String bz;//币种
	private Boolean iskpjs;//是否开票结束
	private Boolean isskjs;//是否收款结束
	private String status;//行状态
	
	private Xskpzhub xskpzhub;
	
	public Float getDpkl() {
		return dpkl;
	}

	public void setDpkl(Float dpkl) {
		this.dpkl = dpkl;
	}

	public Long getYthh() {
		return ythh;
	}

	public void setYthh(Long ythh) {
		this.ythh = ythh;
	}

	public Float getShulv() {
		return shulv;
	}

	public void setShulv(Float shulv) {
		this.shulv = shulv;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public Long getXskpzhibid() {
		return xskpzhibid;
	}

	public void setXskpzhibid(Long xskpzhibid) {
		this.xskpzhibid = xskpzhibid;
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

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
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

	public Float getZke() {
		return zke;
	}

	public void setZke(Float zke) {
		this.zke = zke;
	}

	public String getYtdjh() {
		return ytdjh;
	}

	public void setYtdjh(String ytdjh) {
		this.ytdjh = ytdjh;
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

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getCk() {
		return ck;
	}

	public void setCk(String ck) {
		this.ck = ck;
	}

	public String getShdw() {
		return shdw;
	}

	public void setShdw(String shdw) {
		this.shdw = shdw;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Boolean getIskpjs() {
		return iskpjs;
	}

	public void setIskpjs(Boolean iskpjs) {
		this.iskpjs = iskpjs;
	}

	public Boolean getIsskjs() {
		return isskjs;
	}

	public void setIsskjs(Boolean isskjs) {
		this.isskjs = isskjs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Xskpzhub getXskpzhub() {
		return xskpzhub;
	}

	public void setXskpzhub(Xskpzhub xskpzhub) {
		this.xskpzhub = xskpzhub;
	}
}
