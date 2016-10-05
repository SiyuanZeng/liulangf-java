/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.thread.basic;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A mutex lock blocks all other threads from entering what we call a critical region.
 * This critical region usually involves accessing or updating one or more pieces of data that
 * are shared between the threads. But sometimes, we can distinguish between reading a piece
 * of data and modifying a piece of data.
 * 
 * Read-Write Lock: The rules for read-write locks:
 * <ul>
 *   <li>Any number of threads can hold a given read-write lock for reading as long as
 *     no thread holds the read-write lock for writing.</li>
 *   <li>A read-write lock can be allocated for writing only if 
 *     no thread holds the read-write lock for reading or writing</li>
 * </ul>
 * 
 * Stated another way, any number of threads can have read access to a given piece of data as long as 
 * no thread is reading or modifying the piece of data. A piece of data can be modified only if 
 * no other thread is reading the data.
 * 
 * This sharing of access to a given resource is also known as shared-exclusive locking(共享-独占), because obtaining
 * a read-write lock for reading is called a shared lock(共享锁), and obtaining a read-write lock for writing is called
 * an exclusive lock(独占锁);
 * 
 *
 * @author Quqing Liu
 */
@Contention
public class ReadWriteLocks {
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public void read() {
		rwl.readLock().lock();
		try {
			//read
		} finally {
			rwl.readLock().unlock();
		}
	}
	
	public void write() {
		rwl.writeLock().lock();
		try {
			//write
		} finally {
			rwl.writeLock().unlock();
		}
		
	}
	
	/**
	 * Read-write locks can be implemented using just mutexes and condition variables.
	 * 
	 * Read-write locks can provided more concurrency than a plain mutex lock when the data
	 * being protected is read more often than it is written.
	 * 
	 * Read-write locks can b implemented easily using just mutexes and condition variables.
	 */
	public void summary() {
	}

}
