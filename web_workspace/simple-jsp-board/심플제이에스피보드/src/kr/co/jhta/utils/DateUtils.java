package kr.co.jhta.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String yyyymmdd(Date date) {
		if(date == null) {
			return "";
		}
		return YYYYMMDD.format(date);
	}
	public static String yyyymmddhhmmss(Date date) {
		if(date == null) {
			return "";
		}
		return YYYYMMDDHHMMSS.format(date);
	}
}
