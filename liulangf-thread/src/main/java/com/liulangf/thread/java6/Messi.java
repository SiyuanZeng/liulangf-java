package com.liulangf.thread.java6;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-6
 */
public class Messi extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(Messi.class);
	
	private Object sigLock = new Object();
	
	/**
	 * 可以看出thread.interrupt() 和 obj.notifyAll() 都可以唤醒 waiting 中的线程。
	 * 但是不同的是：
	 *  1. thread.interrupt() 使 wait() 抛出InterruptedException 异常。
	 *  2. obj.notifyAll() 使 wait() 正常终止, 不抛出异常。
	 * 
	 */
	public void waiting() {
		synchronized (sigLock) {
			try {
				LOGGER.info("I am waiting for someone to wake me up.");
				//sigLock.wait(30L * 1000L);
				TimeUnit.SECONDS.timedWait(sigLock, 30);
			} catch (InterruptedException e) {
				LOGGER.info("Thanks for waking me up!", e);
				//重置中断状态
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public boolean interruptedStatus() {
		return Thread.interrupted();
	}
	
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			LOGGER.warn("", e);
			//重置中断状态
			Thread.currentThread().interrupt();
		}
		
		LOGGER.info("I love Messi!");
		waiting();
		LOGGER.info("I love Messi!");
		
		waiting();
		LOGGER.info("I love Messi!");
	}
	
	/**
	 * using Thread.interrupt() 唤醒 Thread.sleep() 的线程。
	 */
	public void wakeUp() {
		this.interrupt();
		LOGGER.info("isInterrupted is [{}]", this.isInterrupted());
	}
	
	public void signal() {
		synchronized (sigLock) {
			LOGGER.info("It's time to work.");
			sigLock.notifyAll();
		}
	}
	
	@Override
	public void start() {
		LOGGER.info("This is a bad idea.");
		super.start();
	}
	
	public static void main(String... args) throws Exception {
		Messi messi = new Messi();
		messi.start();
		LOGGER.info("messi.isInterrupted [{}]", messi.interruptedStatus());
		TimeUnit.SECONDS.sleep(2);
		
		messi.wakeUp();
		LOGGER.info("messi.isInterrupted [{}]", messi.interruptedStatus());

		TimeUnit.SECONDS.sleep(3);
		messi.signal();
		TimeUnit.SECONDS.sleep(3);
		messi.wakeUp();
		LOGGER.info("messi.isInterrupted [{}]", messi.interruptedStatus());
	}
}
