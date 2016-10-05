package com.liulangf.ioc.guice.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceImpl implements Service {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void go() {
		logger.info("Go go go.");
	}
}
