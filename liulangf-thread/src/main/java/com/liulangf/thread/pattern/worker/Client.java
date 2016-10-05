package com.liulangf.thread.pattern.worker;

import java.util.Random;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class Client extends Thread {
    private final Channel channel;
    private static final Random random = new Random();
    private volatile boolean terminated = false;
    public Client(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }
    
    @Override
    public void run() {
    	try {
            try {
                for (int i = 0; !terminated; i++) {
                    Request request = new Request(getName(), i);
                    channel.putRequest(request);
                    Thread.sleep(random.nextInt(1000));
                }
            } catch (InterruptedException e) {
            	terminated = true;
            }
    	} finally {
    		System.out.println(Thread.currentThread().getName() + " is terminated.");
    	}

    }
    
    public void stopThread() {
    	terminated = true;
    	interrupt();
    }
}
