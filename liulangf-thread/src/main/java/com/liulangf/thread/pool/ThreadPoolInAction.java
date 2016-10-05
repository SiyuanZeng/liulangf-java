package com.liulangf.thread.pool;

import java.util.LinkedList;

/**
 * http://www.ibm.com/developerworks/library/j-jtp0730/index.html
 * 
 * @author liulangf
 *
 */
public class ThreadPoolInAction {


	/**
	 * What we usually want is a work queue combined with a fixed group of worker threads, 
	 * which uses wait() and notify() to signal waiting threads that new work has arrived. 
	 * The work queue is generally implemented as some sort of linked list with an associated 
	 * monitor object.
	 */
	void work_queue_and_thread_pool() {
	}
	
	class WorkQueue {
		private final int nThreads;
		private final PoolWorker[] threads;
		private final LinkedList<Runnable> taskQueue;
		
		public WorkQueue(int nThreads) {
			this.nThreads = nThreads;
			taskQueue = new LinkedList<Runnable>();
			threads = new PoolWorker[this.nThreads];
			
			for (int i = 0; i < nThreads; i++) {
				threads[i] = new PoolWorker();
				threads[i].start();
			}
		}
		
		public void execute(Runnable r) {
			synchronized (taskQueue) {
				taskQueue.addLast(r);
				taskQueue.notify();
			}
		}
		private class PoolWorker extends Thread {
			public void run() {
				Runnable r;
				while (true) {
					synchronized (taskQueue) {
						while (taskQueue.isEmpty()) {
							try {
								taskQueue.wait();
							} catch (InterruptedException e) {
							}
						}
						r = taskQueue.removeFirst();
					}

					//if we don't catch RuntimeException, the pool could leak threads
					try {
						r.run();
					} catch (RuntimeException e) {
						//you might want to log somthing here.
					}
				}
			}
		}
	}
	
}
