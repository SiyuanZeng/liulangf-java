package com.liulangf.pattern.gof.behavioral.observer.eventbus;

public class OurTestEvent {

	private final int message;
	
	public OurTestEvent(int message) {
		this.message = message;
	}
	
	public int getMessage() {
		return message;
	}
}
