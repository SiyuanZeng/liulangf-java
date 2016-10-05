package com.liulangf.pattern.gof.behavioral.observer.robertc;

public class MockTimeSource extends Subject implements TimeSource {

	private int hours;
	private int minutes;
	private int seconds;
	
	public void setTime(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		notifyObserver();
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
}
