package com.liulangf.thread.pattern.single;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class BusyMutex implements Mutex {
	private boolean busy = false;
	
	@Override
	public void lock() {
		synchronized (this) {
			while (busy) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//?
			busy = true;
		}
	}
	
	@Override
	public void unlock() {
		synchronized (this) {
			busy = false;
			notifyAll();
		}
	}

}
