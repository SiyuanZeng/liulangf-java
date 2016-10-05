package com.liulangf.thread;

/**
 * From <<Effective Java>>, First Edition.
 * Item 48: Synchronize access to shared mutable data.
 * 
 * A recommended way to stop one thread from another is to have the first thread 
 * poll a boolean field that is initially false but can be set to true by the 
 * second thread to indicate that the first thread is to stop itself. Because 
 * reading and writing a boolean field is atomic.
 * 
 * @author liulangf
 *
 */
public class StoppableThread extends Thread {
	private boolean stopRequested = false;
	
	public void run() {
		boolean done = false;
		
		while (!stopRequested() && !done) {
			//..do something
			//done = true;
		}
	}
	
	public void requestStop() {
		stopRequested = true;
	}
	
	private synchronized boolean stopRequested() {
		return stopRequested;
	}
	
}
