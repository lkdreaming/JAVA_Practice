package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购订单子表
 * @author zd
 *
 */
public class Cgddzhib implements Serializable{
	private Long cgddzhibid;//主键
	private Long hh;//行号
	private String spbm;//商品编码
	private String spmc;//商品名称
	private Boolean hgb;//行关闭
	private String gbr;//关闭人
	private Date gbrq;//关闭日期
	
	private String xh;//型号
	private Long sl;//数量
	private String dw;//单位
	private Float hsdj;//含税单价
	private Float wsdj;//无税单价
	private Float shuilv;//税率 
	private Float hsje;//含税金额
	private Float wsje;//无税金额
	private Float se;//税额
	private String zp;//赠品
	private String lydj;//来源单据
	private Long ljthsl;//累计退货数量
	private Boolean hstatus;//行状态
	
	private Cgddzhub cgddzhub;

	public Long getCgddzhibid() {
		return cgddzhibid;
	}

	public void setCgddzhibid(Long cgddzhibid) {
		this.cgddzhibid = cgddzhibid;
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

	public Boolean getHgb() {
		return hgb;
	}

	public void setHgb(Boolean hgb) {
		this.hgb = hgb;
	}

	public String getGbr() {
		return gbr;
	}

	public void setGbr(String gbr) {
		this.gbr = gbr;
	}

	public Date getGbrq() {
		return gbrq;
	}

	public void setGbrq(Date gbrq) {
		this.gbrq = gbrq;
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

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
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

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getLydj() {
		return lydj;
	}

	public void setLydj(String lydj) {
		this.lydj = lydj;
	}

	public Long getLjthsl() {
		return ljthsl;
	}

	public void setLjthsl(Long ljthsl) {
		this.ljthsl = ljthsl;
	}

	public Boolean getHstatus() {
		return hstatus;
	}

	public void setHstatus(Boolean hstatus) {
		this.hstatus = hstatus;
	}

	public Cgddzhub getCgddzhub() {
		return cgddzhub;
	}

	public void setCgddzhub(Cgddzhub cgddzhub) {
		this.cgddzhub = cgddzhub;
	}

}
