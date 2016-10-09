package com.liulangf.thread.basic;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class MyThreadFactoryTest {
    
    private ExecutorService executor;
    private int times = 20;
    private CyclicBarrier barrier = new CyclicBarrier(times);
    
    @Before
    public void setUp() {
        //executor = Executors.newFixedThreadPool(20);  
        executor = createPool();
    }
    
    private ExecutorService createPool() {
        return new ThreadPoolExecutor(0, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2),
                new MyThreadFactory());
    }

    @Test
    public void start() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(times);
        System.out.println("==Begin!==");
        execute(latch, barrier, times);
        latch.await();
        
        System.out.println("======\n\n\n");
        latch = new CountDownLatch(times);
        barrier.reset();
        execute(latch, barrier, times);
        latch.await();
        
        System.out.println("==Over!==");
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
                    executor.execute(createJob(latch));
                }
            }.start();
        }
    }
    
    private Runnable createJob(final CountDownLatch latch) {
        return new Runnable() {
            public void run() {
                try {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " --->>> " + new Date());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                } finally {
                    latch.countDown();
                }
            }
        };
    }

}
