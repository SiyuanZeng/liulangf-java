package com.liulangf.pattern.gof.structural.proxy.virtual;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.RandomUtils;

public class RealSubject implements Subject {

	@Override
	public long execute() {
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
		
		return RandomUtils.nextLong();
	}

}
