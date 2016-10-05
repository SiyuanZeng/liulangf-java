package com.liulangf.thread.pattern.suspension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Server extends Thread {
    private Random random;
    private RequestQueue requestQueue;
    public Server(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }
    
    @Override
    public void run() {
        try {
			for (int i = 0; i < 100; i++) {
			    Request request = requestQueue.getRequest();
			    System.out.println(Thread.currentThread().getName() + " handles  " + request);
			    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
