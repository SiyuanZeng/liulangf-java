package com.liulangf.thread;

import java.util.Random;

import com.liulangf.thread.java6.GuardedBlock;

/**
 * http://java.sun.com/docs/books/tutorial/essential/concurrency/guardmeth.html
 * 线程间的协作
 * Object.wait();
 * Object.notify();
 * Object.notifyAll();
 * 
 * java6 中的BlockingQueue 更简单。
 * 
 * @see com.liulangf.thread.java6.GuardedBlock
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class GuardedBlock2 {
	private boolean joy; 
	
	public void guardedJoy(int a) {
		//Simple loop guard. Wastes processor time. Don't do this! 
		//Using wait() notify() to coordinate.
		while (!joy) {
			System.out.println("Joy has been achieved!");
		}
	}
	
	/**
	 * A more efficient guard invokes Object.wait to suspend the current thread. 
	 * The invocation of wait does not return until another thread has issued a notification 
	 * that some special event may have occurred — though not necessarily the event this thread is waiting for:
	 * 
	 * Note: Always invoke wait inside a loop that tests for the condition being waited for. 
	 * Don't assume that the interrupt was for the particular condition you were waiting for, 
	 * or that the condition is still true.
	 */
	public synchronized void guardedJoy() {
		//This guard only loops once for each special event, which may not
		//be the event we're waiting for.
		while (!joy) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
			System.out.println("Joy and efficiency have been achieved!");
		}
	}
	
	/**
	 * When wait is invoked, the thread releases the lock and suspends execution. 
	 * At some future time, another thread will acquire the same lock and invoke Object.notifyAll, 
	 * informing all threads waiting on that lock that something important has happened:
	 */
	public synchronized void notifyJoy() {
		joy = true;
		notifyAll();
	}

	// producer - consumer
	public static void main(String... args) {
		Drop drop = new Drop();
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();
	}
}

class Drop {
	private String message;
	private boolean empty = true;
	
	public synchronized String take() {
		//wait until message is available
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		//Toggle status
		empty = true;
		//Notify producer that status has changed
		notifyAll();
		return message;
	}
	
	public synchronized void put(String message) {
		//Wait until message has been retrieved
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		//Toggle status
		empty = false;
		this.message = message;
		//Notify consumer that status has changed
		notifyAll();
	}
}

class Producer implements Runnable {
	private Drop drop;
	public Producer(Drop drop) {
		this.drop = drop;
	}
	
	@Override
	public void run() {
		String infos[] = {
		    "Mares eat oats",
		    "Does eat oats",
		    "Little lambs eat ivy",
		    "A kid will eat ivy too"
		};
		Random random = new Random();
		
		for (String i : infos) {
			drop.put(i);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
		drop.put("DONE");
	}
}

class Consumer implements Runnable {
	private Drop drop;
	public Consumer(Drop drop) {
		this.drop = drop;
	}
	
	@Override 
	public void run() {
		Random random = new Random();
		for (String m = drop.take(); !m.equals("DONE"); m = drop.take()) {
			System.out.format("Message received : %s%n", m);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
	}
}
