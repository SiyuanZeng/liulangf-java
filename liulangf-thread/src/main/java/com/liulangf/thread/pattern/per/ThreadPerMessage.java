package com.liulangf.thread.pattern.per;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class ThreadPerMessage {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
