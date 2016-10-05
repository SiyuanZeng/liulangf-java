package com.liulangf.thread.pattern.pc;

import java.util.concurrent.TimeUnit;

/**
 * 如何取消一个操作? 
 * 通过判断线程的中断状态来实现
 * Thread.interrupt();  //设置中断状态
 * Thread.interrupted();//清除中断状态
 * 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class HostCancel {
    public static void main(String[] args) {
        // 执行Host的大型处理的线程
        Thread executor = new Thread() {
            public void run() {
                System.out.println("Host.execute BEGIN");
                try {
                    Host.execute(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Host.execute END");
            }
        };

        // 启动
        executor.start();

        // 休息约15秒
        try {
        	TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
        }

        // 执行取消
        System.out.println("***** interrupt *****");
        executor.interrupt();
    }
}

class Host {
    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            doHeavyJob();
        }
    }
    
    private static void doHeavyJob() throws InterruptedException {
        // 下面的程序吗
        // 是用来取代[无法取消繁重的工作]
        // (停留约10秒的时间)
        System.out.println("doHeavyJob BEGIN");
        long start = System.currentTimeMillis();
        while (start + 5000 > System.currentTimeMillis()) {
            // busy loop
        	busy();
        }
        System.out.println("doHeavyJob END");
    }
    
    private static void busy() throws InterruptedException {
    	TimeUnit.SECONDS.sleep(1);
    	System.out.println(System.currentTimeMillis());
    }
}


