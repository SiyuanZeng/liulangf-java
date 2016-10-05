package com.liulangf.thread.java6;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent.*;
 * TimeUnit:
 * CopyOnWriteArrayList:
 * 
 * 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Summary {
	private String name;
	transient final ReentrantLock lock = new ReentrantLock();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	/**
	 * CopyOnWriteArrayList
	 */
	public void copyOnWrite() {
		CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList<String>();
	}

	public void tu() {
		helloTimeUnit(TimeUnit.NANOSECONDS); //纳秒
		helloTimeUnit(TimeUnit.MICROSECONDS);//微妙
		helloTimeUnit(TimeUnit.MILLISECONDS);//毫秒
		helloTimeUnit(TimeUnit.SECONDS);
		helloTimeUnit(TimeUnit.HOURS);
		helloTimeUnit(TimeUnit.DAYS);
	}
	
	public void helloTimeUnit(TimeUnit tu) {
		System.out.println(tu.toString());
		try {
			tu.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//tu.timedJoin(thread, timeout);
		//tu.timedWait(obj, timeout);
	}
	
	public void modify(String name) {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			//do something modification
			this.setName(name);
		} finally {
			lock.unlock();
		}
	}

	public static void main(String...args) {
		new Summary().tu();
	}
	
	
}
