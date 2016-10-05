/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.dsl.martin.calendar.three;

import java.util.ArrayList;
import java.util.List;

/**
 * Using Multiple Builders for the Calendar (Java):
 * Here's an absurdly simple version of using multiple builders with the same Calendar example. 
 * To motivate this, let's assume that an event is immutable and all its data has to be created in a constructor.
 * 
 * With this, I need to capture the data for an event as I build up the fluent expression. 
 * I could do this with fields in the calendar builder (e.g., currentEventStartTime) but it seems better 
 * to make an event builder to do this (essentially, using a Construction Builder).
 * 
 * In Java, a variation on this scheme is to make the child builder an inner class of the parent. 
 * With this approach, you don't need the parent field.
 *
 * @author Quqing Liu
 */
public class CalendarBuilder {
	private List<EventBuilder> events = new ArrayList<EventBuilder>();
	
	
	public EventBuilder add(String name) {
		EventBuilder child = new EventBuilder(this);
		events.add(child);
		child.setName(name);
		return child;
	}
	
	/**
	 * When the builder is asked for its content, it creates the whole structure of Semantic Model objects.
	 * @return
	 */
	public Calendar getContent() {
		Calendar result = new Calendar();
		for (EventBuilder e : events) {
			result.addEvent(e.getContent());
		}
		return result;
	}
	
}
