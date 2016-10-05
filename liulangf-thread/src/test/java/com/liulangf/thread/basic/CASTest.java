package com.liulangf.thread.basic;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class CASTest {

	@Test
	public void test() {
		AtomicInteger ai = new AtomicInteger(8);
		
		for (;;) {
			if (ai.compareAndSet(20, 30)) {
				System.out.println("==compareAndSet==" + ai.get());
				return;
			} else {
				ai.incrementAndGet();
				System.out.println("==incrementAndGet...===");
			}
		}
	}

}
