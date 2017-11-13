package cn.itcast.gyl.domain.cggl;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购入库单子表
 * @author zd
 *
 */
public class Cgrkdzhib implements Serializable{
	private Long cgrkdzhibid;//主键
	private Long hh;//行号
	private String chbm;//存货编码
	private String chmc;//存货名称
	private String dw;//单位
	private String xh;//型号
	private Long sl;//数量
	private String pch;//批次号
	private Date scrq;//生产日期
	private Date sxrq;//失效日期
	private Long yssl;//应收数量
	private Long sssl;//实收数量
	private Float dj;//单价
	private Float je;//金额
	private Date rkrq;//入库日期
	private String zp;//赠品
	private String ytdjh;//源头单据号
	private String ythh;//源头行号
	private String lydjh;//来源单据号
	private String lyhh;//来源行号
	
	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	private Cgrkdzhub cgrkdzhub;

	public Long getCgrkdzhibid() {
		return cgrkdzhibid;
	}

	public void setCgrkdzhibid(Long cgrkdzhibid) {
		this.cgrkdzhibid = cgrkdzhibid;
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
	
	public String getPch() {
		return pch;
	}

	public void setPch(String pch) {
		this.pch = pch;
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

	public Long getYssl() {
		return yssl;
	}

	public void setYssl(Long yssl) {
		this.yssl = yssl;
	}

	public Long getSssl() {
		return sssl;
	}

	public void setSssl(Long sssl) {
		this.sssl = sssl;
	}

	public Float getDj() {
		return dj;
	}

	public void setDj(Float dj) {
		this.dj = dj;
	}

	public Float getJe() {
		return je;
	}

	public void setJe(Float je) {
		this.je = je;
	}

	public Date getRkrq() {
		return rkrq;
	}

	public void setRkrq(Date rkrq) {
		this.rkrq = rkrq;
	}

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getYtdjh() {
		return ytdjh;
	}

	public void setYtdjh(String ytdjh) {
		this.ytdjh = ytdjh;
	}

	public String getYthh() {
		return ythh;
	}

	public void setYthh(String ythh) {
		this.ythh = ythh;
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

	public Cgrkdzhub getCgrkdzhub() {
		return cgrkdzhub;
	}

	public void setCgrkdzhub(Cgrkdzhub cgrkdzhub) {
		this.cgrkdzhub = cgrkdzhub;
	}
}
