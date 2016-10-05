package com.liulangf.thread.dump;

import java.util.concurrent.TimeUnit;

public class ThreadStatuses {

	Thread.State state = null;
	
	public void allStates() {
		Thread.State NEW = Thread.State.NEW;
		Thread.State BLOCKED = Thread.State.BLOCKED;
		Thread.State RUNNABLE = Thread.State.RUNNABLE;
		Thread.State TERMINATED = Thread.State.TERMINATED;
		Thread.State TIMED_WAITING = Thread.State.TIMED_WAITING;
		Thread.State WAITING = Thread.State.WAITING;
	}
	
	
	public static void main(String...args) {
		System.out.println(Thread.currentThread().getState());
		System.out.println(new Thread().getState());
		Thread t = new Thread();
		t.start();
		System.out.println(t.getState());
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println("T2 run over!");
				} catch (InterruptedException e) {
				}
			}
		});
		t2.start();
		
		
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println(t2.getState());
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
		}
		
		System.out.println(t.getState());
		System.out.println(t2.getState());
	}
	
	
}
