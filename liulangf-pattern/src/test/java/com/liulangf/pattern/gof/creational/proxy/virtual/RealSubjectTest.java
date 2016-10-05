package com.liulangf.pattern.gof.creational.proxy.virtual;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liulangf.pattern.gof.structural.proxy.virtual.RealSubject;
import com.liulangf.pattern.gof.structural.proxy.virtual.Subject;

public class RealSubjectTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void testExecute() {
		Subject sub = new RealSubject();
		log.info("Start ...");
		log.info("The result is [{}].", sub.execute());
		log.info("Over!");
	}

}
