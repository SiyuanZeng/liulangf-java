/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.calendar.one;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 *
 * @author Quqing Liu
 */
public class Event {
	private String name, location;
	private LocalDate date;
	private LocalTime startTime, endTime;

	public Event(String name) {
		this.name = name;
	}
	
	public Event on(int year, int month, int day) {
		this.date = new LocalDate(year, month, day);
		return this;
	}
	
	public Event from(String startTime) {
		this.startTime = parseTime(startTime);
		return this;
	}
	
	public Event to(String endTime) {
		this.endTime = parseTime(endTime);
		return this;
	}
	
	private LocalTime parseTime(String time) {
		final DateTimeFormatter fmt = ISODateTimeFormat.hourMinute();
		return new LocalTime(fmt.parseDateTime(time));
	}
	
	public Event at(String location) {
		this.location = location;
		return this;
	}
}
