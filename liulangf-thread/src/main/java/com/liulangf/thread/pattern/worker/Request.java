package com.liulangf.thread.pattern.worker;

import java.util.Random;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class Request {
    private final String name;
    private final int number;
    private static final Random random = new Random();
    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public void execute() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        Thread.sleep(random.nextInt(1000));
    }
    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
