package com.liulangf.thread.pool.ebus;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import javax.inject.Inject;

/**
 * 简单的对象池实现。
 */
public class SimplePool implements Pool<WorkerThread> {

    private WorkerProvider provider;
    private LinkedList<WorkerThread> workers;
    private Semaphore items;
    private Semaphore spaces;
    
    @Inject
    public SimplePool(WorkerProvider provider, int capacity) {
        this.provider = provider;
        items = new Semaphore(0);
        spaces = new Semaphore(capacity);
        workers = new LinkedList<WorkerThread>();
    }
    
    @Override
    public WorkerThread get() throws InterruptedException {
        items.acquire();
        WorkerThread wt = doGet();
        spaces.release();
        return wt;
    }

    @Override
    public void put(WorkerThread object) throws InterruptedException {
        spaces.acquire();
        doPut(object);
        items.release();
        
    }
    
    private synchronized WorkerThread doGet() {
        if (workers.isEmpty()) {
            WorkerThread wt = provider.newWorker();
            return wt;
        }
        return workers.removeLast();
    }
    
    private synchronized void doPut(WorkerThread object) {
        workers.addLast(object);
    }
}
