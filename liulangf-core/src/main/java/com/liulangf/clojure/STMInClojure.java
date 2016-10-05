package com.liulangf.clojure;

import java.util.concurrent.Callable;

import clojure.lang.LockingTransaction;
import clojure.lang.Ref;

public class STMInClojure {

	
	public void index() throws Exception {
		Ref ref = new Ref("Hello");
		LockingTransaction.runInTransaction(new Callable<Object>() {
			public Object call() {
				return null;
			}
		});
		             
	}
	
}
            