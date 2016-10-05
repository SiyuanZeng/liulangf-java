/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.calendar.two;

import java.util.ArrayList;
import java.util.List;

/**
 * A Calendar with a single object builder.
 *
 * @author Quqing Liu
 */
public class Calendar {
	private List<Event> events = new ArrayList<Event>();
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public List<Event> getEvents() {
		return this.events;
	}
	
	public static void main(String...args) {
		CalendarBuilder builder = new CalendarBuilder();
		builder
		    .add("DSL tutorail")
		        .on(2009, 11, 8)
		        .from("09:00")
		        .to("16:00")
		        .at("Aarhus Music Hall")
		    .add("Making use of Patterns")
		        .on(2009, 10, 5)
		        .from("14:15")
		        .to("15:45")
		        .at("Aarhus Music hall")
		    ;
		Calendar cal = builder.getContent();
		cal.toString();
	}
}
