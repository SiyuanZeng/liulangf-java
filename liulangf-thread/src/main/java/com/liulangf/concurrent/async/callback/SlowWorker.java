package com.liulangf.concurrent.async.callback;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuQing Liu
 *
 */
public class SlowWorker {
	
	private final transient Logger logger = LoggerFactory.getLogger(getClass());
	
	public void doWork() {
		logger.info("==Working working working!==");
		try {
			TimeUnit.SECONDS.sleep(2);
			logger.info("===Work DONE!===");
		} catch (InterruptedException e) {
			logger.info("I was interrupted.");
		}
	}

}
