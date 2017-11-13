package cn.itcast.gyl.domain.xsgl;

import java.io.Serializable;
import java.util.Date;

public class Xsddzhib implements Serializable{
	private Long xsddzhibid;//主键
	private Long hh;//行号
	private Long lyhh;//来源行号  如果是退货单，而退货单又是根据销售订单生成的，指向该销售订单的行号
	private String chmc;//存货名称
	private String chbm;//存货编码
	private String xh;//型号
	private String jldw;//计量单位
	private Long sl;//数量
	private Float shulv;//税率
	private Float dpkl;//单品扣率
	private Float zdkl;//整单扣率
	private Float wsdj;//无税单价
	private Float hsdj;//含税单价
	private Float wsje;//无税金额
	private Float hsje;//含税金额
	private Float se;//税额
	private Float zke;//折扣额
	private String pc;//批次
	private String gs;//提供商品的公司
	private String fhck;//发货仓库
	private String shdw;//收货单位
	private Date jhfhrq;//计划发货日期
	private Date yqshrq;//要求收货日期
	private String spfl;//商品分类
	private String hstatus;//行状态
	private String zp;//赠品
	
	private Long yfwcksl;//应发未出库数量
	private Long ljfhsl = 0l;//累计发货数量   当刚创建销售订单时，这个数为0
	private Long ljcksl = 0l;//累计出库数量    当刚创建销售订单时，这个数为0
	private Long ljkpsl = 0l;//累计开票数量    当刚创建销售订单时，这个数为0
	private Long ljyssl = 0l;//累计应收数量  当刚创建销售订单时，  这个数为0
	private Boolean isckgb = false;//是否出库关闭      当刚创建销售订单时，这个数为false
	private Boolean isfhgb = false;//是否发货关闭      当刚创建销售订单时，这个数为false
	private Boolean iskpgb = false;//是否开票关闭      当刚创建销售订单时，这个数为false
	private Boolean isskjs = false;//是否收款结束      当刚创建销售订单时，这个数为false
	
	private Xsddzhub xsddzhub;//销售订单主表

	public Long getLyhh() {
		return lyhh;
	}

	public void setLyhh(Long lyhh) {
		this.lyhh = lyhh;
	}

	public Long getXsddzhibid() {
		return xsddzhibid;
	}

	public void setXsddzhibid(Long xsddzhibid) {
		this.xsddzhibid = xsddzhibid;
	}

	public Long getHh() {
		return hh;
	}

	public void setHh(Long hh) {
		this.hh = hh;
	}

	public String getChmc() {
		return chmc;
	}

	public void setChmc(String chmc) {
		this.chmc = chmc;
	}

	public String getChbm() {
		return chbm;
	}

	public void setChbm(String chbm) {
		this.chbm = chbm;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw;
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public Float getShulv() {
		return shulv;
	}

	public void setShulv(Float shulv) {
		this.shulv = shulv;
	}

	public Float getDpkl() {
		return dpkl;
	}

	public void setDpkl(Float dpkl) {
		this.dpkl = dpkl;
	}

	public Float getZdkl() {
		return zdkl;
	}

	public void setZdkl(Float zdkl) {
		this.zdkl = zdkl;
	}

	public Float getWsdj() {
		return wsdj;
	}

	public void setWsdj(Float wsdj) {
		this.wsdj = wsdj;
	}

	public Float getHsdj() {
		return hsdj;
	}

	public void setHsdj(Float hsdj) {
		this.hsdj = hsdj;
	}

	public Float getWsje() {
		return wsje;
	}

	public void setWsje(Float wsje) {
		this.wsje = wsje;
	}

	public Float getHsje() {
		return hsje;
	}

	public void setHsje(Float hsje) {
		this.hsje = hsje;
	}

	public Float getSe() {
		return se;
	}

	public void setSe(Float se) {
		this.se = se;
	}

	public Float getZke() {
		return zke;
	}

	public void setZke(Float zke) {
		this.zke = zke;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getFhck() {
		return fhck;
	}

	public void setFhck(String fhck) {
		this.fhck = fhck;
	}

	public String getShdw() {
		return shdw;
	}

	public void setShdw(String shdw) {
		this.shdw = shdw;
	}

	public Date getJhfhrq() {
		return jhfhrq;
	}

	public void setJhfhrq(Date jhfhrq) {
		this.jhfhrq = jhfhrq;
	}

	public Date getYqshrq() {
		return yqshrq;
	}

	public void setYqshrq(Date yqshrq) {
		this.yqshrq = yqshrq;
	}

	public String getSpfl() {
		return spfl;
	}

	public void setSpfl(String spfl) {
		this.spfl = spfl;
	}

	public String getHstatus() {
		return hstatus;
	}

	public void setHstatus(String hstatus) {
		this.hstatus = hstatus;
	}

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public Long getYfwcksl() {
		return yfwcksl;
	}

	public void setYfwcksl(Long yfwcksl) {
		this.yfwcksl = yfwcksl;
	}

	public Long getLjfhsl() {
		return ljfhsl;
	}

	public void setLjfhsl(Long ljfhsl) {
		this.ljfhsl = ljfhsl;
	}

	public Long getLjcksl() {
		return ljcksl;
	}

	public void setLjcksl(Long ljcksl) {
		this.ljcksl = ljcksl;
	}

	public Long getLjkpsl() {
		return ljkpsl;
	}

	public void setLjkpsl(Long ljkpsl) {
		this.ljkpsl = ljkpsl;
	}

	public Long getLjyssl() {
		return ljyssl;
	}

	public void setLjyssl(Long ljyssl) {
		this.ljyssl = ljyssl;
	}

	public Boolean getIsckgb() {
		return isckgb;
	}

	public void setIsckgb(Boolean isckgb) {
		this.isckgb = isckgb;
	}

	public Boolean getIsfhgb() {
		return isfhgb;
	}

	public void setIsfhgb(Boolean isfhgb) {
		this.isfhgb = isfhgb;
	}

	public Boolean getIskpgb() {
		return iskpgb;
	}

	public void setIskpgb(Boolean iskpgb) {
		this.iskpgb = iskpgb;
	}

	public Boolean getIsskjs() {
		return isskjs;
	}

	public void setIsskjs(Boolean isskjs) {
		this.isskjs = isskjs;
	}

	public Xsddzhub getXsddzhub() {
		return xsddzhub;
	}

	public void setXsddzhub(Xsddzhub xsddzhub) {
		this.xsddzhub = xsddzhub;
	}
	
	
}
