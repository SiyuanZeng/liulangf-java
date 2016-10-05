package com.liulangf.thread.java6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * http://www.ibm.com/developerworks/java/library/j-5things4.html
 * BlockingQueue 用于线程间的协作。
 * 
 * @author LiuYuQing
 * @version 1.0 2010-7-7
 */
public class GuardedBlock {
	public static void main(String...args) {
		BlockingQueue<String> drop = new ArrayBlockingQueue<String>(1, true);
		//BlockingQueue<String> drop = new SynchronousQueue<String>();
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();
	}
}

class Producer implements Runnable {
	private BlockingQueue<String> drop;
	List<String> messages = Arrays.asList(
		"Mares eat oats",
		"Does eat oats",
		"Little lambs eat ivy",
		"Would't you eat ivy too?"
	);
	
	public Producer(BlockingQueue<String> drop) {
		this.drop = drop;
	}
	
	@Override public void run() {
		try {
			for (String s : messages) {
				drop.put(s);
			}
			drop.put("DONE");
		} catch (InterruptedException e) {
			
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<String> drop;
	public Consumer(BlockingQueue<String> drop) {
		this.drop = drop;
	}
	
	@Override public void run() {
		try {
			String msg = null;
			while (!(msg = drop.take()).equals("DONE")) {
				System.out.println(msg);
			}
		} catch (InterruptedException e) {
			
		}
	}
}
