package com.liulangf.pattern.eda.simple;

import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//EventSource
public class Clock {

	private long interval = 1000L;
	private int times = 20;
	private boolean sync = true;
	private Vector<TickListener> listeners = new Vector<TickListener>();
	
	
	private Executor pool = Executors.newFixedThreadPool(2);
	
	public void setSync(boolean sync) {
		this.sync = sync;
	}
	
	public boolean getSync() {
		return this.sync;
	}
	
	public void addListener(TickListener li) {
		listeners.add(li);
	}
	
	public void removeListener(TickListener li) {
		listeners.remove(li);
	}
	
	protected void doTickEvent() {
		synchronized (this) {
			final TickEvent e = new TickEvent(this);
			for (final TickListener tl : listeners) {
				if (sync) {
					tl.onEvent(e);
				} else {
					pool.execute(new Runnable() {
						public void run() {
							tl.onEvent(e);
						}
					});
				}
				
			}
		}
	}
	
	public void tick() {
		int t = 0;
		while (t++ < times) {
			this.doTickEvent();
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println("\n\nGoodBye!");
	}
	
	public static void main(String...args) {
		Clock clock = new Clock();
		clock.addListener(new ClockPlugin());
		clock.tick();
		
		clock.setSync(false);
		clock.tick();
	}
	
}
