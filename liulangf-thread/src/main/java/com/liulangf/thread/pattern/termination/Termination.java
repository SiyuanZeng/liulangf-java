package com.liulangf.thread.pattern.termination;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class Termination {
    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            Counter t = new Counter();
            t.start();
            
            TimeUnit.SECONDS.sleep(10);

            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main: join");

            //等待t 结束
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END");
    }
}
