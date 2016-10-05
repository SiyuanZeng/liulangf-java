package com.liulangf.pattern.eda.simple;

public class ClockPlugin implements TickListener {
	
	public void onEvent(TickEvent event) {
		System.out.print('>');
	}
}
