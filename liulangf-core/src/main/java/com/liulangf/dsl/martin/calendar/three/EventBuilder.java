/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.calendar.three;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 *
 * @author Quqing Liu
 */
public class EventBuilder {
	private CalendarBuilder parent;
	
	private String name, location;
	private LocalDate date;
	private LocalTime startTime, endTime;
	
	public EventBuilder(CalendarBuilder parent) {
		this.parent = parent;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public EventBuilder on(int year, int month, int day) {
		this.date = new LocalDate(year, month, day);
		return this;
	}
	
	public EventBuilder from(String startTime) {
		this.startTime = parseTime(startTime);
		return this;
	}
	
	public EventBuilder to(String endTime) {
		this.endTime = parseTime(endTime);
		return this;
	}

	private LocalTime parseTime(String time) {
		final DateTimeFormatter fmt = ISODateTimeFormat.hourMinute();
		return new LocalTime(fmt.parseDateTime(time));
	}
	
	public EventBuilder at(String location) {
		this.location = location;
		return this;
	}

	/**
	 * The add method indicates punctuation for the next event. Since the event builder will receive this call, 
	 * it needs a method for it, which it delegates to its parent to build the new event builder.
	 * @param name
	 * @return
	 */
	public EventBuilder add(String name) {
		return parent.add(name);
	}
	
	public Event getContent() {
		return new Event(name, location, date, startTime, endTime);
	}
}
