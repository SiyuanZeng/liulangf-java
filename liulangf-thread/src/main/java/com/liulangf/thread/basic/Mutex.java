package com.liulangf.thread.basic;

/**
 * Mutex, mutual exclusion : lock & unlock
 * 
 * A mutex, which stands for mutual exclusion, is the most basic form of synchronization.
 * A mutex is used to protect a critical region, to make certain that only one thread at 
 * a time executes the code within the region(assuming a mutex that is being shared by the threads)
 * or that only one process at a time executes the code within the region(assuming a mutex is 
 * beging shared by the processes).
 * The normal outline of code to protect a critical region looks like:
 * <pre>
 *   lock_the_mutex(...);
 *   critical region
 *   unlock_the_mutex(...);
 * </pre>
 * 
 * Since only one thread at a time can lock a given mutex, this guarantees that only one thread
 * at a time can be executing the instructions within the critical region.
 * 
 * Although we talk of critical region being protected by a mutex, what is really protected is the
 * data being manipulated within the critical region. That is, a mutex is normally used to protect 
 * shared data that is being shared between multiple threads or between multiple processes.
 *
 * @author Quqing Liu
 */
@Contention
interface Mutex {
	/**
	 * Mutex locks are cooperative locks. That is, if the shared data is linked list(for example),
	 * then all the threads that manipulates the linked list must obtain the mutex lock before 
	 * manipulating the list. Nothing can prevent one thread from manipulating the linked list 
	 * without first obtaining the mutex.
	 * 
	 * Mutexes are for locking and cannot be used for waiting.
	 */
	void lock();
	void unlock();
}