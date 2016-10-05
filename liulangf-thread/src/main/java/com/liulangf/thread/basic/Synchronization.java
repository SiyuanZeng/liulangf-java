/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.basic;

/**
 * synchronization : 同步
 * asynchronization: 异步
 * 
 * <p>
 * Type of synchronization:
 * <ul>
 *   <li>Contention 	: 竞争  	： mutex</li>
 *   <li>Coordination 	: 协作	：condition variable</li>
 * </ul>
 * 
 * Type of algorithm(concurrent data structures):
 * <ul>
 *   <li>Blocking synchronization 		: 阻塞算法</li>
 *   <li>Non-Blocking synchronization 	: 非阻塞算法</li>
 * </ul>
 * 
 * Type of locking:
 * <ul>
 *   <li>Coarse-Grained Locking</li>
 *   <li>Fine-Grained Locking</li>
 * </ul>
 * 
 * 
 * Synchronization is normally needed to allow sharing of data between threads or processes.
 * <p>
 * Mutexes and Condition Variables are the building blocks of synchronization.
 * A mutex is for locking and a condition variable is for waiting. These are two different types
 * of synchronization and both are needed.
 * A condition variable is always associated with a mutex.
 * A mutex is always associated with a condition variable.
 * 
 * Mutex 				: lock & unlock
 * Condition variable 	: wait & notify ; await & signal;
 * 
 * <p>
 * Mutexes are used to protect critical regions of code, so that only one thread at a time is executing 
 * within the critical region. Sometimes a thread obtains a mutex lock and then discovers that it needs
 * to wait for some condition to be true. When this happens, the thread waits on a condition variable.
 *
 * @author Quqing Liu
 */
public class Synchronization {
	
	/**
	 * <ul>
	 *   <li>1. A mutex must always be unlocked by the thread that locked the mutex,
	 *          whereas a semaphore post need not be performed by the same thread that did
	 *          the semaphore wait.</li>
	 *   <li>2. A mutex is either locked or unlocked(a binary state, similar to a binary semaphore).</li>
	 *   <li>3. Since a semaphore has state associated with it(its count), a semaphore post is always
	 *          remembered. When a condition variable is signaled, if no thread is waiting for this
	 *          condition variable, the signal is lost. </li>
	 * </ul>
	 * 
	 */
	public void differenceAmongSemaphore_Mutex_Condition() {
	}
	
	/**
	 * <<The Posix.1 Rationale>> states the following reason for providing semaphores along with
	 * mutexes and condition variables: "Semaphores are provided primarily to provide a means of 
	 * synchronization for processes; these processes may or may not share memory. Mutexes and 
	 * condition variables are specified as synchronization mechanisms between threads; these threads
	 * always share memory. Both are synchronization paradigms that have been in widespread use for
	 * a number of years. Each set of primitives is particularly well matched to certain problems." 
	 * 
	 * 
	 * 
	 */
	public void whySemaphoreAlongWithMutex_Condition() {
	}
	
	
}
