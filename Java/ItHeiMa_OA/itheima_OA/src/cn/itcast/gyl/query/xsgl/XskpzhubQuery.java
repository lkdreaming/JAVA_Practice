package cn.itcast.gyl.query.xsgl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.itcast.gyl.query.BaseQuery;

/**
 * 销售开票主表
 * 
 * @author zd
 * 
 */
public class XskpzhubQuery extends BaseQuery {
	private Long xskpzhubid;// 主键
	private String gs;// 公司
	private String ddh;// 发票号 按照订单号走
	private Date kprq;// 开票日期
	private String fplx;// 发票类型 专用发票 普通发票 营业税 收据 其他 增值税发票
	private Date kjnd;// 会计年度 用的是哪年的发票
	private String kh;// 客户
	private String khdymc;// 客户打印名称
	private String bm;// 部门
	private String ywy;// 业务员
	private String shdw;// 收货单位
	private String shdz;// 收货地址
	private Float zdzk;// 整单折扣
	private String ck;// 仓库
	private String bz;// 币种
	private Float fpzje;// 发票总金额
	private String status;// 状态
	private String zdr;// 制单人
	private Date zdsj;// 制单时间
	private String spr;// 审批人
	private Date spsj;// 审批时间
	private String xgr;// 修改人
	private Date xgsj;// 修改时间

	public Long getXskpzhubid() {
		return xskpzhubid;
	}

	public void setXskpzhubid(Long xskpzhubid) {
		this.xskpzhubid = xskpzhubid;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getDdh() {
		return ddh;
	}

	public void setDdh(String ddh) {
		this.ddh = ddh;
	}

	public Date getKprq() {
		return kprq;
	}

	public void setKprq(Date kprq) {
		this.kprq = kprq;
	}

	public String getFplx() {
		return fplx;
	}

	public void setFplx(String fplx) {
		this.fplx = fplx;
	}

	public Date getKjnd() {
		return kjnd;
	}

	public void setKjnd(Date kjnd) {
		this.kjnd = kjnd;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getKhdymc() {
		return khdymc;
	}

	public void setKhdymc(String khdymc) {
		this.khdymc = khdymc;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
	}

	public String getShdw() {
		return shdw;
	}

	public void setShdw(String shdw) {
		this.shdw = shdw;
	}

	public String getShdz() {
		return shdz;
	}

	public void setShdz(String shdz) {
		this.shdz = shdz;
	}

	public Float getZdzk() {
		return zdzk;
	}

	public void setZdzk(Float zdzk) {
		this.zdzk = zdzk;
	}

	public String getCk() {
		return ck;
	}

	public void setCk(String ck) {
		this.ck = ck;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Float getFpzje() {
		return fpzje;
	}

	public void setFpzje(Float fpzje) {
		this.fpzje = fpzje;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getZdr() {
		return zdr;
	}

	public void setZdr(String zdr) {
		this.zdr = zdr;
	}

	public Date getZdsj() {
		return zdsj;
	}

	public void setZdsj(Date zdsj) {
		this.zdsj = zdsj;
	}

	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}

	public Date getSpsj() {
		return spsj;
	}

	public void setSpsj(Date spsj) {
		this.spsj = spsj;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	@Override
	protected void addWhere() {
		if (this.gs != null) {
			addWhere("o.gs=?", gs);
		}
		if (this.ddh != null) {
			addWhere("o.ddh=?", ddh);
		}
		if (this.kprq != null) {
			addWhere("o.kprq=?", kprq);
		}
		if (this.fplx != null) {
			addWhere("o.fplx=?", fplx);
		}
		if (this.kjnd != null) {
			addWhere("o.kjnd=?", kjnd);
		}
		if (StringUtils.isNotBlank(kh)) {
			addWhere("o.kh=?", kh);
		}

		if (this.khdymc != null) {
			addWhere("o.khdymc=?", khdymc);
		}
		if (this.bm != null) {
			addWhere("o.bm=?", bm);
		}
		if (this.ywy != null) {
			addWhere("o.ywy=?", ywy);
		}
		if (this.shdw != null) {
			addWhere("o.shdw=?", shdw);
		}
		if (this.shdz != null) {
			addWhere("o.shdz=?", shdz);
		}
		if (this.zdzk != null) {
			addWhere("o.zdzk=?", zdzk);
		}
		if (this.ck != null) {
			addWhere("o.ck=?", ck);
		}
		if (this.fpzje != null) {
			addWhere("o.fpzje=?", fpzje);
		}
		if (this.status != null) {
			addWhere("o.status=?", status);
		}
		if (this.zdr != null) {
			addWhere("o.zdr=?", zdr);
		}
		if (this.zdsj != null) {
			addWhere("o.zdsj=?", zdsj);
		}
		if (this.spr != null) {
			addWhere("o.spr=?", spr);
		}
		if (this.spsj != null) {
			addWhere("o.spsj=?", spsj);
		}
		if (this.xgr != null) {
			addWhere("o.xgr=?", xgr);
		}
		if (this.xgsj != null) {
			addWhere("o.xgsj=?", xgsj);
		}
	}
}
