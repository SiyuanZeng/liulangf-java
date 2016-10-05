package com.liulangf.thread.pool.ebus;

/**
 *
 */
public class WorkerThread extends Thread {
    private Runnable task;
    private boolean alive;
    private Pool<WorkerThread> pool;
    
    public WorkerThread(Pool<WorkerThread> pool) {
        this.pool = pool;
        this.task = null;
        this.alive = true;
    }
    
    public synchronized void run() {
        while (alive) {
            waitForTask();
            if (alive) {
                try {
                    try {
                        task.run();
                    } catch (Exception e) {
                        //throw e;
                    } 
                } finally {
                    task = null;
                }
                notify();
                backToPool();
            }
        }
    }
    
    private void backToPool() {
        if (!alive) {
            return;
            //throw new IllegalStateException("Attempted to recycle dead thread.");
        }
        //put thread back to pool
        Pool<WorkerThread> lpool = pool;
        if (lpool != null) {
            try {
                lpool.put(this);
            } catch (Exception e) {
            }
        }
    }

    public synchronized void setTask(Runnable task) {
        this.task = task;
        notifyAll();
    }
    
    private void waitForTask() {
        synchronized (this) {
            while (alive && task == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        
    }
}
