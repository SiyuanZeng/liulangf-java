package com.liulangf.thread.pool.ebus;

import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;

/**
 * ThreadFactory 简单实现。
 */
public class SimpleThreadFactory implements ThreadFactory, WorkerProvider {

    @Inject
    private Pool<WorkerThread> pool;
    
    @Override
    public Thread newThread(Runnable r) {
        WorkerThread wt = getWorker();
        wt.setTask(r);
        return wt;
    }
    
    @Override
    public WorkerThread newWorker() {
        WorkerThread wt = new WorkerThread(pool);
        return wt;
    }
    
    private WorkerThread getWorker() {
        try {
            return pool.get();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

}
