package com.liulangf.util;

import java.util.Calendar;

/**
 * @author LiuYuQing
 * @version 1.0 2010-12-8
 */
public class ISoftStoneUtil {
	
	public static void main(String... args) {
		System.out.println(generatePassword());
	}
	
	/**
	 * 密码必须包含数字,字符,数字???
	 * 每60天更换一次密码
	 * (+)(月份)(yqliu)(月天数)(*)
	 * @return
	 */
	public static String generatePassword() {
		StringBuilder sb = new StringBuilder();
		sb.append("+");
		sb.append(getMonth());
		sb.append("yqliu");
		sb.append(getMonthDates());
		sb.append("*");
		return sb.toString();
	}
	
	private static String getMonth() {
		Calendar cal = Calendar.getInstance();
		return "" + (cal.get(Calendar.MONTH) + 1);
	}

	private static String getMonthDates() {
		Calendar cal = Calendar.getInstance();
		return "" + cal.getMaximum(Calendar.DAY_OF_MONTH);
	}
}
