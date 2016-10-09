package com.liulangf.thread.basic;


/**
 *
 */
public class MyThread extends Thread {

    private Runnable task;
    
    // 已经送出终止请求则为true
    private volatile boolean shutdownRequested = false;

    //  终止请求
    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    // 判断终求请求是否已经送出
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    //动作
    public final void run() {
        try {
            while (!shutdownRequested) {
                doWork();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            doShutdown();
        }
    }
    
    public synchronized void setTask(Runnable task) {
        this.task = task;
        notifyAll();
    }
    
    public synchronized Runnable getTask() throws InterruptedException {
        if (task == null) {
            wait();
        }
        return task;
    }

    private void doShutdown() {
        System.out.println("doShutdown");
    }
    
    public synchronized void start() {
        System.out.println("Starting.........");
        if (getState() != State.NEW) {
            System.out.println("I'm runnable!");
            return;
        }
        super.start();
    }

    //  作业
    private synchronized void doWork() throws InterruptedException {
        getTask().run();
    }
}
