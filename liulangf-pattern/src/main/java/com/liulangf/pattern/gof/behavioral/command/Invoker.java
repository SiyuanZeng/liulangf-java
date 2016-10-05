package com.liulangf.pattern.gof.behavioral.command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Invoker 可以控制command的执行mode
 * 
 * @author Quqing Liu
 */
public class Invoker {
	
	private ExecutorService executor = Executors.newFixedThreadPool(3); 
	
	/**
	 * 对Command 异步执行
	 * 
	 * @param command
	 */
	public void invoke(final Command command) {
		executor.execute(new Runnable() {
			public void run() {
				command.execute();
			}
		});
	}
	
}
