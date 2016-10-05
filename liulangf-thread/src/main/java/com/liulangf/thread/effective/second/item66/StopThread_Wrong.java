package com.liulangf.thread.effective.second.item66;

// Broken! - How long would you expect this program to run? - Page 259

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class StopThread_Wrong {
    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested)
                    System.out.println(i++);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        latch.await();
    }
}
