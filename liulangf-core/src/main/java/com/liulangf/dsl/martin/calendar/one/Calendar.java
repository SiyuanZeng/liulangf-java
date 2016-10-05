/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.calendar.one;

import java.util.ArrayList;
import java.util.List;

import com.liulangf.dsl.martin.calendar.one.Event;

/**
 * A Calendar without ExpressionBuilder;
 *
 * @author Quqing Liu
 */
public class Calendar {
	private List<Event> events = new ArrayList<Event>();
	public Event add(String name) {
		Event newEvent = new Event(name);
		events.add(newEvent);
		return newEvent;
	}
	
	public static void main(String...args) {
		Calendar cal = new Calendar();
		cal.add("DSL tutorail")
		    .on(2009, 11, 8)
		    .from("09:00")
		    .to("16:00")
		    .at("Aarhus Music Hall")
		    ;
		cal.add("Making use of Patterns")
		    .on(2009, 10, 5)
		    .from("14:15")
		    .to("15:45")
		    .at("Aarhus Music hall")
		    ;
	}
}
