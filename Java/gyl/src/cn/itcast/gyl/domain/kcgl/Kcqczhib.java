package cn.itcast.gyl.domain.kcgl;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存期初子表
 * @author zd
 *
 */
public class Kcqczhib implements Serializable{
	private Long ckqczhibid;//主键
	private Long hh;//行号
	private String chbm;//存货编码
	private String chmc;//存货名称
	private String gg;//规格
	private String xh;//型号
	private String dw;//单位
	private String pc;//批次
	private Long sl;//数量
	private Float dj;//单价
	private Float je;//金额
	private Date rkrq;//入库日期
	
	private Kcqczhub kcqczhub;

	public Long getCkqczhibid() {
		return ckqczhibid;
	}

	public void setCkqczhibid(Long ckqczhibid) {
		this.ckqczhibid = ckqczhibid;
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

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
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

	public Kcqczhub getKcqczhub() {
		return kcqczhub;
	}

	public void setKcqczhub(Kcqczhub kcqczhub) {
		this.kcqczhub = kcqczhub;
	}
}
