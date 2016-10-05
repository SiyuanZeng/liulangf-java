package com.liulangf.thread.pattern.suspension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class Client extends Thread {
    private Random random;
    private RequestQueue requestQueue;
    public Client(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }
    
    @Override
    public void run() {
        try {
			for (int i = 0; i < 1000; i++) {
			    Request request = new Request("No." + i);
			    System.out.println(Thread.currentThread().getName() + " requests " + request);
			    requestQueue.putRequest(request);
			    TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
