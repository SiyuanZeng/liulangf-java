package com.liulangf.tdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiuYuQing
 */
public class HelloWorld {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);
	
	public int square(int p) {
		LOGGER.info("square({})", p);
		return p * p;
	}
	
	public int add(int a, int b) {
		LOGGER.info("add({}, {})", a, b);
		return a + b;
	}
}
