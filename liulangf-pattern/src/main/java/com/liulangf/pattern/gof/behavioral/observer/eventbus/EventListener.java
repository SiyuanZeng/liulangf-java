package com.liulangf.pattern.gof.behavioral.observer.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener {
	
	private int lastMessage = 0;
	
	@Subscribe
	public void listen(OurTestEvent event) {
		lastMessage = event.getMessage();
	}
	
	public int getLastMessage() {
		return lastMessage;
	}

}
