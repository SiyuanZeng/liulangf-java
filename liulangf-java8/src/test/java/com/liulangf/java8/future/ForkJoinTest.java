package com.liulangf.java8.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ForkJoinTest {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		ForkJoinTask<?> task = 
		ForkJoinPool.commonPool().submit(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Hello World");
			} catch (Exception e) {
			}
		});
		
		System.out.println(task.get());
	}

}
