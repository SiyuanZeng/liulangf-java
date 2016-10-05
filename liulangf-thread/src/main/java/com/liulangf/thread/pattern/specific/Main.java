package com.liulangf.thread.pattern.specific;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-13
 */
public class Main {
    public static void main(String[] args) {
        new Client("Alice").start();
        new Client("Bobby").start();
        new Client("Chris").start();
    }
}
