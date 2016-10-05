package com.liulangf.thread.pattern.worker;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-9
 */
public class WorkerThread {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        Client alice = new Client("Alice", channel);
        Client bobby = new Client("Bobby", channel);
        Client chris = new Client("Chris", channel);
        alice.start();
        bobby.start();
        chris.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        alice.stopThread();
        bobby.stopThread();
        chris.stopThread();
        channel.stopAllWorkers();
    }
}
