package com.liulangf.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Quqing Liu
 */
public class MyServiceImpl implements MyService {
	private final static transient Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);
	public void doSomething() {
		LOGGER.info("Just a demo for using SPI to load a service implementation.");
	}

}
