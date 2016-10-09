package com.liulangf.thread.java6;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Another advanced threading feature introduced in Tiger is that of atomic type. 
 * An atomic type is simply a type that has atomic operations available to it—it manages to be thread-safe 
 * despite being essentially lock-free.
 * 
 *
 * @author Quqing Liu
 */
public class AtomicOperation {
	private static final Logger LOGGER = LoggerFactory.getLogger(AtomicOperation.class);

	
	/**
	 * Hardware Support for Concurrency: Compare-And-Swap(CAS)
	 * The approach taken by most processor architectures, including IA32 and Sparc, is to implement a 
	 * compare‐and‐swap(CAS) instruction.
	 * 
	 * CAS has three operands ‐ a memory location V on which to operate, the expected old value A, 
	 * and the new value B. CAS atomically updates V to the new value B, but only if the value in V matches the 
	 * expected old value A; otherwise it does nothing. In either case, it returns the value currently in V. 
	 * (The variant called compare‐and‐set instead returns whether the operation succeeded.)
	 * 
	 * CAS means "I think V should have the value A; if it does, put B there, otherwise don't change it 
	 * but tell me I was wrong."
	 * 
	 * When multiple threads attempt to update the same variable simultaneously using CAS, one wins and updates the
	 * variable's value, and the rest lose. But the losers are not punished by suspension, as they could be if they
	 * failed to acquire a lock; instead, they are told that they didn't win the race this time but can try again. 
	 * Because a thread that loses a CAS is not blocked, it can decide whether it wants to try again, take some other 
	 * recovery action, or do nothing.
	 * 
	 * CAS addresses the problem of implementing atomic read‐modify‐write sequences without locking, 
	 * because it can detect interference from other threads.
	 *
	 * @author Quqing Liu
	 */
	class CompareAndSet {
		
		boolean compareAndSet(int expected, int newValue) {
			return false;
		}
		
	}
	
	private AtomicInteger count = new AtomicInteger();
	public void increment() {
		count.incrementAndGet();
	}
	public int getCount() {
		return count.get();
	}

	public static void main(String...args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		final AtomicOperation counter = new AtomicOperation();
		for (int i = 0; i < 100; i++) {
			executor.execute(new Runnable() {
				@Override public void run() {
					counter.increment();
					LOGGER.info("{} - {}", Thread.currentThread().getName(), counter.getCount());
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
					}
				}
			});
		}
		
		try {
			TimeUnit.SECONDS.sleep(105);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
	}
}
