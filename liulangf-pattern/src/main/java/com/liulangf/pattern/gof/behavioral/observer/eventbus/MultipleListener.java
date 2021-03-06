package com.liulangf.pattern.gof.behavioral.observer.eventbus;

import com.google.common.eventbus.Subscribe;

public class MultipleListener {
	private Integer lastInteger = 0;
	private Long lastLong = 0L;
	
	@Subscribe
	public void listenInteger(Integer event) {
		lastInteger = event;
	}
	
	@Subscribe
	public void listenLong(Long event) {
		lastLong = event;
	}
	
	public Integer getLastInteger() {
		return lastInteger;
	}
	
	public Long getLastLong() {
		return lastLong;
	}
	

}
