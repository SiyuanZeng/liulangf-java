package com.liulangf.thread.pattern.termination;

import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
public class Hanoi extends Thread {
    // 已经送出终止请求则为true
    private volatile boolean shutdownRequested = false;
    //送出终止请求的时刻
    private volatile long requestedTimeMillis = 0;

    //  终止请求
    public void shutdownRequest() {
        requestedTimeMillis = System.currentTimeMillis();
        shutdownRequested = true;
        interrupt();
    }

    //  判断终止请求是否已经送出
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // 动作
    public void run() {
        try {
            for (int level = 0; !shutdownRequested; level++) {
                System.out.println("==== Level " + level + " ====");
                doWork(level, 'A', 'B', 'C');
                System.out.println("");
            }
        } catch (InterruptedException e) {
            this.interrupt();
        } finally {
            doShutdown();
        }
    }

    // 作业
    private void doWork(int level, char posA, char posB, char posC) throws InterruptedException {
        if (level > 0) {
        	//这段代码要注意
            if (shutdownRequested) {
                throw new InterruptedException();
            }
            doWork(level - 1, posA, posC, posB);
            System.out.print(posA + "->" + posB + " ");
            doWork(level - 1, posC, posB, posA);
        }
    }

    // 终止处理
    private void doShutdown() {
        long time = System.currentTimeMillis() - requestedTimeMillis;
        System.out.println("doShutdown: Latency = " + time + " msec.");
    }
    
    
    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            // 启动线程
        	Hanoi t = new Hanoi();
            t.start();

            // 稍微空出的一端时间
            TimeUnit.SECONDS.sleep(10);

            // 对线程送出终至请求
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main: join");

            // 等待线程结束
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END");
    }
    
}
