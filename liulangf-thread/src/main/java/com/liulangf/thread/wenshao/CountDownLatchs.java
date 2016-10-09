package com.liulangf.thread.wenshao;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Quqing Liu
 */
public class CountDownLatchs {
	
	/**
	 * Starting more threads, and waiting for them to come.
	 */
	public void waitAllToCome() throws InterruptedException {
		final int count = 10;
		final CountDownLatch completeLatch = new CountDownLatch(count);
		
		for (int i = 0; i < count; i++) {
			new Thread() {
				public void run() {
					//do xxx
					
					//counting works
					completeLatch.countDown();
				}
			}.start();
		}
		
		//Waiting for all threads to finish.
		completeLatch.await();
	}
	
	
	public void startAllThreadAtTheSameTime() {
		final CountDownLatch startLatch = new CountDownLatch(1);
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					try {
						startLatch.await();
						//do the job here.
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
					
					//do xxx
					
				}
			}.start();
		}
		
		startLatch.countDown();
	}
	
	public void waitWithoutCountDownLatch1() throws InterruptedException {
		final Object completeSignal = new Object();
		Thread thread = new Thread() {
			public void run() {
				//do xxx
				
				//finish and signal
				synchronized (completeSignal) {
					completeSignal.notifyAll();
				}
			}
		};
		
		synchronized (completeSignal) {
			thread.start();
			completeSignal.wait();
		}
	}
	
	public void waitWithoutCountDownLatch2() throws InterruptedException {
		final Lock lock = new ReentrantLock();
		final Condition completeSignal = lock.newCondition();
		Thread thread = new Thread() {
			public void run() {
				//do xxx
				
				//finish and signal
				try {
					lock.lock();
				    completeSignal.signalAll();
				} finally {
					lock.unlock();
				}
			}
		};
		
		try {
			lock.lock();
			thread.start();
			completeSignal.await();
		} finally {
			lock.unlock();
		}
		
		
	}

}
