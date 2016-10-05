package com.liulangf.thread.wenshao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列是一种常用的并发数据结构，常用于生产者-消费者模式。
 * BlockingQueue 中,要使用 put/take, 而非offer/poll. 如果要使用offer/poll, 也是
 * 要用带等待时间参数的offer/poll.
 * 
 * 1.producer -> blockingQueue.put(object); 如果队列满则阻塞
 * 2.consumer 
 *   for (;;) {
 *       //如果队列空则阻塞
 *       Object o = blockingQueue.take();
 *   }
 * java中的阻塞队列：
 * ArrayBlockingQueue  <== 最常用
 * LinkedBlockingQueue <== 不会满的
 * SynchronousQueue    <== size=0
 * PriorityBlockingQueue
 * CompletionService(BlockingQueue + Executor)
 * TransferQueue(JDK7中更快的SynchronousQueue) 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-11
 */
public class BlockingQueues {
	final BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<Object>(10);
	
	public void usingBlockingQueue() {
		//1. 一直等待
		new Thread("Consumer Thread") {
			public void run() {
				for (;;) {
					try {
						//take 等到有数据了才继续
						Object object = blockingQueue.take();
						//handle(object);
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		}.start();
		
		//2. 等待一些时间
		new Thread("Consumer thread") {
			public void run() {
				for (;;) {
					try {
						Object object = blockingQueue.poll(20, TimeUnit.SECONDS);
						if (object == null) {
							continue;
						}
					} catch (InterruptedException e) {
						break;
					}
				}
			}
			
		}.start();
	}
}

//MyBlockingQueue
class MyBlackingQueue1 {
	private Object notEmpty = new Object();
	private Queue<Object> linkedList = new LinkedList<Object>();
	
	public Object take() throws InterruptedException {
		//要执行wait，必须先取得该对象的锁。执行wait后，锁会释放。被唤醒前，需要先获得锁。
		synchronized (notEmpty) {
			if (linkedList.size() == 0) {
				notEmpty.wait();
			}
			return linkedList.poll();
		}
	}
	
	public void put(Object object) {
		//要执行notify和notifyAll，必须先获取该对象的锁
		synchronized (notEmpty) {
			if (linkedList.size() == 0) {
				notEmpty.notifyAll();
			}
			linkedList.add(object);
		}
	}
	
}

class MyBlockingQueue2 {
	private Object notEmpty = new Object();
	private Object notFull = new Object();
	private Queue<Object> linkedList = new LinkedList<Object>();
	private int maxLength = 10;
	
	public Object take() throws InterruptedException {
		// notEmpty notFull 需要分别加锁
		synchronized (notEmpty) {
			if (linkedList.size() == 0) {
				notEmpty.wait();
			}
			synchronized (notFull) {
				if (linkedList.size() == maxLength) {
					notFull.notifyAll();
				}
				return linkedList.poll();
			}
		}
	}

	public void put(Object object) throws InterruptedException {
		//notEmpty notFull 都需要锁，并且锁的顺序要一致
		synchronized (notEmpty) {
			if (linkedList.size() == 0) {
				notEmpty.notifyAll();
			}
			synchronized (notFull) {
				if (linkedList.size() == maxLength) {
					notFull.wait();
				}
				linkedList.add(object);
			}
		}
	}
	
}


/**
 * wait -- notify
 * await -- signal 
 */
class MyBlockingQueue3 {
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();// 一个Lock 可以创建多个Condition
	private Queue<Object> linkedList = new LinkedList<Object>();
	private int maxLength = 10;
	
	public Object take() throws InterruptedException {
		//要执行await,必须先获得Condition的锁
		//await后锁会释放
		//被唤醒前也许要先获得Condition的锁
		lock.lock();
		try {
			if (linkedList.size() == 0) {
				notEmpty.await();
			}
			if (linkedList.size() == maxLength) {
				notFull.signalAll();
			}
			return linkedList.poll();
		} finally {
			lock.unlock();
		}
	}
	
	public void put(Object object) throws InterruptedException {
		lock.lock();
		try {
			if (linkedList.size() == 0) {
				notEmpty.signalAll();
			}
			if (linkedList.size() == maxLength) {
				notFull.await();
			}
			linkedList.add(object);
		} finally {
			lock.unlock();
		}
	}
	
}

