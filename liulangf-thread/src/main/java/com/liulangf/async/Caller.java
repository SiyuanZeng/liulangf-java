package com.liulangf.async;

import java.util.concurrent.CountDownLatch;

public class Caller {
	
	public void call(final Callback<String> callback) {
		
		System.out.println("====" + Thread.currentThread().getName());
		
		new Thread() {
			public void run() {
				String re = callback.doCallback(); 
				System.out.println("=======running callback in.=========" + Thread.currentThread().getName() + "==" + re);
			}
		}.start();
	}

	
	public static void main(String... args) throws InterruptedException {
		new Caller().call(new Callback<String>() {
			public String doCallback() {
				return "Hello World!";
			}
		});
		
		new CountDownLatch(1).await();
	}
	
}
