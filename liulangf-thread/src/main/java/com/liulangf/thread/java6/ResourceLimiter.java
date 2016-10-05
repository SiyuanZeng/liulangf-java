package com.liulangf.thread.java6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuYuQing
 * @version 1.0 2010-7-12
 */
public class ResourceLimiter {
	public static void main(String...args) throws Exception {
		Race r = new Race("A", "B", "C", "D", "E", "F");
		System.out.println("It's a race of " + r.getDistance() + " lengths");
		System.in.read();
		r.run();
		new Limiter().run();
	}

}

//Semaphore 信号量
class Limiter {
	public void run() {
		Runnable limitedCall = new Runnable() {
			final Random rand = new Random();
			final Semaphore available =  new Semaphore(3);
			int count = 0;
			@Override public void run() {
				int time = rand.nextInt(15);
				int num = count++;
				try {
					available.acquire();
					System.out.println("Executing long-running action for " + time + " seconds... #" + num);
					TimeUnit.SECONDS.sleep(time);
					System.out.println("Done with #" + num + "!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		//虽然启动了10个线程, 但只有三个是活跃的，其余七个都是空闲的
		for (int i = 0; i < 10; i++) {
			new Thread(limitedCall).start();
		}
	}
}


//CountDownLatch : 门闩
class Race {
	
	private Random rand = new Random();
	private int distance = rand.nextInt(250);
	
	private List<String> horses = new ArrayList<String>();
	
	public Race(String... names) {
		this.horses.addAll(Arrays.asList(names));
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void run() throws InterruptedException{
		System.out.println("And the horses are stepping up to the gate...");
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch finish = new CountDownLatch(horses.size());
		final List<String> places = Collections.synchronizedList(new ArrayList<String>());
		
		for (final String h : horses) {
			new Thread(new Runnable() {
				@Override public void run() {
					try {
						System.out.println(h + " stepping to the gate...");
						start.await();
						int traveled = 0;
						while (traveled < distance) {
							TimeUnit.SECONDS.sleep(rand.nextInt(3));
							traveled += rand.nextInt(15);
							System.out.println(h + " advanced to " + traveled + "!");
						}
						finish.countDown();
						System.out.println(h + " crossed the finish!");
						places.add(h);
					} catch (InterruptedException e) {
						System.out.println("ABORTING RACE!!!");
						e.printStackTrace();
					}
				}
			}).start();
		}//for
		System.out.println("And... they're off!");
		start.countDown();
		finish.await();
		System.out.println("And we have our winners!");
		System.out.println(places.get(0) + " took the gold...");
		System.out.println(places.get(1) + " got the silver...");
		System.out.println(places.get(2) + " took the bronze!");
		//
	}
	
	
}
