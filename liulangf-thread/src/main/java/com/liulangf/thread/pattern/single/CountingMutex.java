package com.liulangf.thread.pattern.single;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class CountingMutex implements Mutex {
	private long locks = 0;
	private Thread owner = null;
	
	@Override
	public synchronized void lock() {
		Thread me = Thread.currentThread();
		while (locks > 0 && owner != me) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//locks == 0 || owner == me
		owner = me;
		locks++;
	}
	
	@Override
	public synchronized void unlock() {
		Thread me = Thread.currentThread();
		if (locks == 0 || owner != me) {
			return;
		}
		//locks > 0 && owner == me
		locks--;
		if (locks == 0) {
			owner = null;
			notifyAll();
		}
	}

}
