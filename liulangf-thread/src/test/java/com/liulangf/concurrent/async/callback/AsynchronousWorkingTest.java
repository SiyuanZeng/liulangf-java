package com.liulangf.concurrent.async.callback;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.liulangf.concurrent.async.callback.AsynchronousWorking;

/**
 * @author YuQing Liu
 *
 */
public class AsynchronousWorkingTest {
	
	private AsynchronousWorking worker = new AsynchronousWorking();

	@Test
	public void test() throws Exception {
		worker.callbackWorker();
		TimeUnit.SECONDS.sleep(4);
	}

}
