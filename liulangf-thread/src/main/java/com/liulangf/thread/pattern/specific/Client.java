package com.liulangf.thread.pattern.specific;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
public class Client extends Thread {
    public Client(String name) {
        super(name);
    }
    public void run() {
        System.out.println(getName() + " BEGIN");
        for (int i = 0; i < 10; i++) {
            Logger.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        Logger.close();
        System.out.println(getName() + " END");
    }
}
