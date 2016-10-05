package com.liulangf.thread.pool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolTest {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private ExecutorService executor;
	
	@Before
	public void setUp() {
		executor = new ThreadPoolExecutor(0, 20,
                200L, TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<Runnable>(5));
	}

	@Test
	public void test() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(20);
		final CyclicBarrier barrier = new CyclicBarrier(20);
		execute(latch, barrier, 20);
		logger.info("====Fire====");
		latch.await();
		logger.info("==Over!==");
	}
	
	void execute(final CountDownLatch latch, final CyclicBarrier barrier, int times) {
		
		for (int i = 0; i < times; i++) {
			new Thread() {
				public void run() {
					try {
						barrier.await();
					} catch (InterruptedException e) {
					} catch (BrokenBarrierException e) {
					}
					executor.execute(task(latch));
				}
			}.start();
		}
	}
	
	Runnable task(final CountDownLatch latch) {
		return new Runnable() {
			public void run() {
				logger.info("==Current thread is [{}].==", Thread.currentThread().getName());
//				try {
//					//TimeUnit.SECONDS.sleep(1);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				latch.countDown();
			}
		};
	}

}
