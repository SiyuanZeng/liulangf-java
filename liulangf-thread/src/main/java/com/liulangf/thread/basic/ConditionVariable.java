package com.liulangf.thread.basic;

/**
 * Condition Variable : 
 *     Waiting and Signalling
 *     Timed Waits and Broadcasts
 * 
 * A mutex is for locking and a condition variable is for waiting. These are two different types
 * of synchronization and both are needed.
 * 
 *
 * @author Quqing Liu
 */
interface ConditionVariable {
	//void wait();
	//void notify();
	//void notifyAll();
	void await();
	void await(long timeout); //timed waits
	void signal();
	void signalAll();         //broadcasts
}