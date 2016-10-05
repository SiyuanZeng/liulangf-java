package com.liulangf.util;

import java.util.Calendar;

/**
 * @author LiuYuQing
 * @version 1.0 2010-12-8
 */
public class ISoftStonePassword {
	private Calendar calendar;
	
	private ISoftStonePassword(Calendar calendar) {
		this.calendar = calendar;
	}
	
	//当月
	public static ISoftStonePassword currentMonth() {
		return new ISoftStonePassword(Calendar.getInstance());
	}
	
	//上个月
	public static ISoftStonePassword lastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DATE, 1);
		return new ISoftStonePassword(calendar);
	}
	
	public static void main(String...args) {
		System.out.println("password of this month[" + currentMonth().generatePassword() + "]");
		System.out.println("password of last month[" + lastMonth().generatePassword() + "]");
	}
	
	/**
	 * 密码必须包含数字,字符,数字???
	 * 每60天更换一次密码
	 * (+)(月份)(yqliu)(月天数)(*)
	 * @return
	 */
	public String generatePassword() {
		StringBuilder sb = new StringBuilder();
		String month = getMonth();
		String dates = getMonthDates();
		sb.append("+");
		sb.append(month);
		sb.append(dates);
		sb.append("yq");
		sb.append("*");
		return sb.toString();
	}
	
	private String getMonth() {
		return "" + (calendar.get(Calendar.MONTH) + 1);
	}

	private String getMonthDates() {
		return "" + calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}
