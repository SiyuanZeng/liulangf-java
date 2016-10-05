package com.liulangf.pattern.gof.structural.proxy.virtual;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class VirtualProxy implements Subject {
	
	private Subject target;
	private ExecutorService executor;
	
	public VirtualProxy(Subject target, ExecutorService executor) {
		this.target = target;
		this.executor = executor;
	}

	@Override
	public long execute() {
		Future<Long> future = executor.submit(new Callable<Long>() {
			@Override
			public Long call() throws Exception {
				return target.execute();
			}
		});
		
		int sec = 0;
		
		while (!future.isDone()) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.print(" " + sec++);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println("");
		try {
			return future.get();
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
		return -1L;
	}

}
