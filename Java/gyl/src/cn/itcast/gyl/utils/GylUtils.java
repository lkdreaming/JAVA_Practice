package cn.itcast.gyl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.junit.Test;

import cn.itcast.gyl.domain.xsgl.Xsddzhib;
import cn.itcast.gyl.domain.xsgl.Xsyddzhib;

public class GylUtils {
	/**
	 * 产生订单号
	 * @param id
	 * @return
	 */
	public static String ddH(Long id){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = simpleDateFormat.format(new Date());
		return dateStr + id;
	}
	
	/**
	 * 如果销售订单来自于销售预订单 销售订单主表的整单价税的计算
	 */
	public static Float calculateZDJSHJ_FromXsydd(Set<Xsyddzhib> xsyddzhibs){
		Float zdjshj = 0f;
		for(Xsyddzhib xsyddzhib:xsyddzhibs){
			/**
			 * 含税金额*(1-单品扣率)
			 */
			zdjshj = zdjshj+xsyddzhib.getHsje()*(1- xsyddzhib.getDpkl());
		}
		return zdjshj;
	}
	
	/**
	 * 直接生成销售订单  销售订单主表的整单价税的计算
	 */
	public static Float calculateZDJSHJ_Direct(Set<Xsddzhib> xsddzhibs){
		Float zdjshj = 0f;
		for(Xsddzhib xsddzhib:xsddzhibs){
			/**
			 * 含税金额*(1-单品扣率)
			 */
			zdjshj = zdjshj+xsddzhib.getHsje()*(1- xsddzhib.getDpkl());
		}
		return zdjshj;
	}
	
	@Test
	public void test(){
		String ddh = GylUtils.ddH(5L);
		System.out.println(ddh);
	}
}
