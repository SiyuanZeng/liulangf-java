/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.calendar.two;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * The basic idea of an Expression Builder is to move these fluent methods onto a separate builder class 
 * that uses regular command-query methods on the domain classes.
 *
 * @author Quqing Liu
 */
public class CalendarBuilder {
	private Calendar content = new Calendar();
	
	public CalendarBuilder add(String name) {
		content.addEvent(new Event());
		getCurrentEvent().setName(name);
		return this;
	}
	
	private Event getCurrentEvent() {
		return content.getEvents().get(content.getEvents().size() -1);
	}
	
	public CalendarBuilder on(int year, int month, int day) {
		getCurrentEvent().setDate(new LocalDate(year, month, day));
		return this;
	}
	
	public CalendarBuilder from(String startTime) {
		getCurrentEvent().setStartTime(parseTime(startTime));
		return this;
	}
	
	public CalendarBuilder to(String endTime) {
		getCurrentEvent().setEndTime(parseTime(endTime));
		return this;
	}

	private LocalTime parseTime(String time) {
		final DateTimeFormatter fmt = ISODateTimeFormat.hourMinute();
		return new LocalTime(fmt.parseDateTime(time));
	}
	
	public CalendarBuilder at(String location) {
		getCurrentEvent().setLocation(location);
		return this;
	}
	
	public Calendar getContent() {
		return this.content;
	}
}
