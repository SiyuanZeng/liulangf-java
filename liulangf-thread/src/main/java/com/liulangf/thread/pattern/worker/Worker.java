package com.liulangf.thread.pattern.worker;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class Worker extends Thread {
    private final Channel channel;
    private volatile boolean terminated = false;
    public Worker(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }
    public void run() {
        try {
            while (!terminated) {
                try {                                           
                    Request request = channel.takeRequest();    
                    request.execute();                          
                } catch (InterruptedException e) {
                    terminated = true;
                }                                               
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
