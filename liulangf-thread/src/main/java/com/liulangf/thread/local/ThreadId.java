package com.liulangf.thread.local;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 *
 * @author liulangf
 *
 */
public class ThreadId {
	
	private static final AtomicInteger nextId = new AtomicInteger(0);
	
	private static final ThreadLocal<Integer> thread_id = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return nextId.getAndIncrement();
		}
	};

	public static int getCurrentThreadId() {
		return thread_id.get();
	}
	
	
	public static void main(String... args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread() {
				public void run() {
					this.setName("Worker-" + getCurrentThreadId());
					System.out.println(this.getName());
				}
			};
			//thread.setName("Worker-" + getCurrentThreadId());
			thread.start();
		}
	}
}
