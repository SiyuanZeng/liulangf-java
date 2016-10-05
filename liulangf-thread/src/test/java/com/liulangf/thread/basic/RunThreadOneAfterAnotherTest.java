package com.liulangf.thread.basic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunThreadOneAfterAnotherTest {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test1() throws InterruptedException {
		Thread t1 = new Thread(() -> log.info("t1"));
		Thread t2 = new Thread(() -> log.info("t2"));
		Thread t3 = new Thread(() -> log.info("t3"));
		
		t1.start();
		t1.join();
		
		t2.start();
		t2.join();
		
		t3.start();
		t3.join();
	}
	
	@Test
	public void test2() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(() -> log.info("t1"));
		executor.submit(() -> log.info("t2"));
		executor.submit(() -> log.info("t3"));
		
		executor.awaitTermination(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test3() {
		CyclicBarrier bariar = new CyclicBarrier(1);
	}
	
	@Test
	public void test4() {
		//wait, notity
		//getPrenode();
		//node.wait(),node.notify();
	}

}
