package com.liulangf.java8;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class ProjectCoinTest {

	@Test
	public void test() throws InterruptedException {
		//List<String> digs = [""];
		
		System.gc();
		new CountDownLatch(1).await();
	}

}
