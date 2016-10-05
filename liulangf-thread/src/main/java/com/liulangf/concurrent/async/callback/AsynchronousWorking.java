package com.liulangf.concurrent.async.callback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuQing Liu
 *
 */
public class AsynchronousWorking {
	private final transient Logger logger = LoggerFactory.getLogger(getClass());
	private ExecutorService es = Executors.newFixedThreadPool(3);
	private CompletionService<String> cs = new ExecutorCompletionService<String>(es);
	
	public void doAsyncWork() {
		final Future<String> future = es.submit(new Callable<String>() {
			public String call() throws Exception {
				new SlowWorker().doWork();
				return null;
			}
		});
		
		logger.info("==Try to do something while the work is being done.==");
		logger.info("==... and more ...==");
		
		try {
			//blocking call - the main thread blocks until task is done
			future.get();
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
		logger.info("==End work.==");
	}
	
	
	public void doMoreWork() {
		List<Future<String>> futures = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++) {
			logger.info("==Start worker {}.==", i);
			futures.add(es.submit(new Callable<String>() {
				public String call() {
					new SlowWorker().doWork();
					return null;
				}
			}));
		}

		logger.info("==Try to do something while the work is being done.==");
		logger.info("==... and more ...==");
		
		int ctr = 0;
		for (Future<String> f : futures) {
			try {
				//blocking call, explicitly waiting for the response from a specific task, 
				//not necessarily the first task that is completed
				//f.get();
				cs.take().get();
				logger.info("** response worker {} **", ++ctr);
			} catch (Exception e) {
			}
		}
		
		logger.info("==End work.==");
	}
	
	public void callbackWorker() {
		Callback<String> callback = new Callback<String>() {
			public void onSuccess(String result) {
				logger.info("==Result received [{}]==", result);
			}
		};
		
		final Future<String> future = es.submit(new CallingbackWorker(callback));
		logger.info("==Try to do something while the work is being done.==");
		logger.info("==... and more ...==");
	}

}

/** 
 * <p>Please call us as we will not call you.[The callback interface.]
 * 
 * <p>Instead of having to ask whether a task has been done, we could prefer to have the workers inform us 
 * of the fact they have completed a job. That is an approach we can take with the asynchronous processing 
 * in Java too. We will not call future.get() or some other method to ask if hopefully our task has been completed. 
 * We instruct the aysynchronous ‘slave’ to come back to us to tell us when it is done. Well, to be more precise:
 *  we make it part of the job  we submit to call us at the end of it. There is no special magic to it, 
 *  no special infrastructure in the Java language for this call back structure. 
 *  It is a simple Design Pattern that we apply.
 */
interface Callback<T> {
	
	public void onSuccess(T result);
	
}

class CallingbackWorker implements Callable<String> {
	private Callback<String> callback;
	public CallingbackWorker(Callback<String> callback) {
		this.callback = callback;
	}
	
	public String call() {
		new SlowWorker().doWork();
		callback.onSuccess("Task Completed!");
		return null;
	}
}