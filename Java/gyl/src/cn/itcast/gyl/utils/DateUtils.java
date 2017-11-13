package cn.itcast.gyl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static Date conformStringToDate(String dateStr) throws Exception{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		return simpleDateFormat.parse(dateStr+" 00:00:00");
	}
}
