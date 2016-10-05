package com.liulangf.pattern.gof.behavioral.observer.robertc;

public class MockTimeSink implements Observer {

	private int hours;
	private int minutes;
	private int seconds;
	private TimeSource source;
	
	public MockTimeSink(TimeSource source) {
		this.source = source;
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	/**
	 * pull_model observer.
	 */
	public void update() {
		hours = source.getHours();
		minutes = source.getMinutes();
		seconds = source.getSeconds();
	}
}
