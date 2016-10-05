package com.liulangf.thread.basic;

import java.lang.Thread.State;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 *
 */
public class ThreadInActionTest {

    @Test
    public  void start() throws InterruptedException {
        Runnable job = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        MyThread t = new MyThread();
        t.setTask(job);
        
        t.start();
        State s = t.getState();
        
        t.start();
        TimeUnit.SECONDS.sleep(12);
        t.shutdownRequest();
        t.join();
        s = t.getState();
        System.out.println(s);
    }

}