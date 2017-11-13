package cn.itcast.gyl.query.xsgl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.itcast.gyl.query.BaseQuery;

public class XsysdzhubQuery extends BaseQuery {
	private Long ddh;
	private String gs;
	private Date rq;//日期
	private Date qsrq;//起算日期
	private String wldx;//往来对象
	private String ks;//客商
	private String bm;//部门
	private String ywy;//业务员
	private String sxbz;//生效标志
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String shr;//审核人
	private Date shrq;//审核日期
	private String qzr;//签字人
	private Date qzrq;//签字日期
	private String xgr;//修改人
	private Date xgrq;//修改日期

	@Override
	protected void addWhere() {
		if(this.ddh != null){
			addWhere("o.ddh=?", ddh);
		}
		if(this.gs != null){
			addWhere("o.gs=?",gs);
		}
		if(this.rq!=null){
			addWhere("o.rq=?",rq);
		}
		if(this.qsrq!=null){
			addWhere("o.qsrq=?",qsrq);
		}
		if(this.wldx!=null){
			addWhere("o.wldx=?",wldx);
		}
		if(this.ks!=null){
			addWhere("o.ks=?",ks);
		}
		if(this.bm!=null){
			addWhere("o.bm=?",bm);
		}
		if(this.ywy!=null){
			addWhere("o.ywy=?",ywy);
		}
		if(this.sxbz!=null){
			addWhere("o.sxbz=?",sxbz);
		}
		
		if(this.zdr!=null){
			addWhere("o.zdr=?",zdr);
		}
		if(this.zdrq!=null){
			addWhere("o.zdrq=?",zdrq);
		}
		if(this.shr!=null){
			addWhere("o.shr=?",shr);
		}
		if(this.shrq!=null){
			addWhere("o.shrq=?",shrq);
		}
		if(this.qzr!=null){
			addWhere("o.qzr=?",qzr);
		}
		if(this.qzrq!=null){
			addWhere("o.qzrq=?",qzrq);
		}
		if(this.xgr!=null){
			addWhere("o.xgr=?",xgr);
		}
		if(this.xgrq!=null){
			addWhere("o.xgrq=?",xgrq);
		}
	}
}
