package com.liulangf.thread.pool.java2s.chapter1;

/**
 *
 */
public class ThreadTask extends Thread {
    private ThreadPool pool;

    public ThreadTask(ThreadPool thePool) {
      pool = thePool;
    }

    public void run() {
      while (true) {
        // blocks until job
        Runnable job = pool.getNext();
        try {
          job.run();
        } catch (Exception e) {
          // Ignore exceptions thrown from jobs
          System.err.println("Job exception: " + e);
        }
      }
    }
}
