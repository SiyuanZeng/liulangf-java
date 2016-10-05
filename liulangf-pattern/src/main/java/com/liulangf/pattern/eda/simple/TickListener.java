package com.liulangf.pattern.eda.simple;

import java.util.EventListener;

public interface TickListener extends EventListener {

	public void onEvent(TickEvent event);
	
}
