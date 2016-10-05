package com.liulangf.thread.wenshao;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * LockFree 算法不需要加锁:
 * 通常都是三个部分组成：
 * 1.循环
 * 2.CAS(compare and set)
 * 3.回退
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-12
 */
public class AtomicLockFree {

}

class Counter {
	private volatile int max = 0;
	public synchronized void set(int value) {
		if (value > max) {
			max = value;
		}
	}
	
	public int getMax() {
		return max;
	}
}

class LockFreeCounter {
	private AtomicInteger max = new AtomicInteger();
	
	public void set(int value) {
		//1. for
		for (;;) {
			int current = max.get();
			if (value > current) {
				//2.compare and set
				if (max.compareAndSet(current, value)) {
					break;
				} else {
					continue;
				}
			} else {
				break;
			}
		}
	}
	
	//while
	public void set2(int value) {
		int current;
		do {
			current = max.get();
			if (value <= current) {
				break;
			}
		} while (!max.compareAndSet(current, value));
	}
	
	public int getMax() {
		return max.get();
	}
	
}
