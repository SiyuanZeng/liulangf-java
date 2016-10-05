package com.liulangf.thread.wenshao;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiuYuQing
 * @version 1.0 2010-11-11
 */
public class Atomics {

	class Counter1 {
		private volatile int count = 0;
		
		public synchronized void increment() {
			count++;
		}
		public int getCount() {
			return count;
		}
	}
	
	/**
	 * 由硬件提供的原子操作指令。
	 * 
	 * AtomicBoolean, 
	 * AtomicInteger
	 * AtomicLong
	 * AtomicReference
	 */
	class Counter2 {
		private AtomicInteger count = new AtomicInteger();
		public void increment() {
			count.incrementAndGet();
		}
		public int getCount() {
			return count.get();
		}
	}
	
}
