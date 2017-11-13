package cn.itcast.gyl.constant;

/**
 * 关于供应链系统的常量的设置
 * @author zd
 *
 */
public class GylConstantKey {
	/**
	 * 销售订单的常量
	 */
	public static final String XSDD_TH_YES = "1";  //为退货的销售订单  为逆向订单
	public static final String XSDD_TH_NOT = "2";  //为出货的销售订单  为正向的订单
	
	public static final String CKJSBZ_YES = "1"; //在销售订单的货品出库结束
	public static final String CKJSBZ_NO = "2";  //没有书库结束
	
	public static final String KPJSBZ_YES = "1"; //开票结束
	public static final String KPJSBZ_NO = "2"; //开票没有结束
	
	public static final String FHJSBZ_YES = "1"; //发货结束
	public static final String FHJSBZ_NO = "2";  //发货没有结束
	
	/**
	 * 行状态
	 */
	public static final String HSTATUS_CLOUSE = "1"; //关闭
	public static final String HSTATUS_OPEN = "2"; //没有关闭
}
