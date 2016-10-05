package com.liulangf.pattern.gof.creational.proxy.virtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liulangf.pattern.gof.structural.proxy.virtual.RealSubject;
import com.liulangf.pattern.gof.structural.proxy.virtual.Subject;
import com.liulangf.pattern.gof.structural.proxy.virtual.VirtualProxy;

public class VirtualProxyTest {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	private ExecutorService executor;
	
	
	private Subject proxy;
	
	@Before
	public void setUp() {
		executor = Executors.newFixedThreadPool(1);
		proxy = new VirtualProxy(new RealSubject(), executor);
	}
	
	@After
	public void tearDown() {
		executor.shutdown();
	}
	
	@Test
	public void testExecute() {
		log.info("Start ...");
		log.info("The result is [{}].", proxy.execute());
		log.info("Over!");
	}

}
