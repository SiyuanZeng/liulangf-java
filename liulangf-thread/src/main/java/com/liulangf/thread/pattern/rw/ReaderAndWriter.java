package com.liulangf.thread.pattern.rw;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-8
 */
public class ReaderAndWriter {
    public static void main(String[] args) {
        Data data = new Data(10);
        new Reader(data).start();
        new Reader(data).start();
        new Reader(data).start();
        new Reader(data).start();
        new Reader(data).start();
        new Reader(data).start();
        new Writer(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new Writer(data, "abcdefghijklmnopqrstuvwxyz").start();
    }
}
