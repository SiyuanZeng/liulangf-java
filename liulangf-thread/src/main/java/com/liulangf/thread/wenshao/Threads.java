package com.liulangf.thread.wenshao;

/**
 * 启动线程的注意事项：
 * 无论何种方式，启动一个线程，都给一个名字！
 * 这对排错诊断系统监控有帮助。
 * 
 * @author LiuYuQing
 * @version 1.0 2010-11-11
 */
public class Threads {
	
	/**
	 * 启动线程，要给个名字
	 */
	public static void starting() {
		//1.
		new Thread("Thread name") {
			public void run() {
				//
			}
		}.start();
		
		//2.
		Thread thread2 = new Thread() {
			public void run() {
				//do...
			}
		};
		thread2.setName("My name is thread2!");
		thread2.start();
		
		//3.
		class MyThread extends Thread {
			public MyThread() {
				super("My name is thread3!");
			}
			
			public void run() {
				
			}
		}
		MyThread thread3 = new MyThread();
		thread3.start();
		
		//4.
		Thread thread4 = new Thread(new Runnable() {
			public void run() {
				//
			}
		});
		thread4.setName("My name is thread4");
		thread4.start();
	}
	
	/**
	 * 对线程的中断要做出恰当的响应
	 */
	public void helloInterrupt() throws InterruptedException {
		//1. 
		new Thread("Thread1") {
			public void run() {
				for (;;) {
					//.....
					if (Thread.interrupted()) {
						break;
					}
				}
			}
		}.start();
		
		//2.
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
		
		//3.
		new Thread("interrupted test") {
			public void run() {
				for (;;) {
					try {
						java.util.concurrent.TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		}.start();
	}

}
