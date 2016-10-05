package com.liulangf.tdd.jmock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiuYuQing
 */
public class TddDemo {
	private final static Logger LOGGER = LoggerFactory.getLogger(TddDemo.class);
	
	private HelloJmock hello;
	
	public TddDemo(HelloJmock hello) {
		this.hello = hello;
	}
	
	public String sayHello(String world) {
		hello.hello();
		hello.world();
		String msg = hello.sayHello(world);
		LOGGER.info("Just a demo. [{}]", msg);
		return "[" + msg + "]";
	}

}
