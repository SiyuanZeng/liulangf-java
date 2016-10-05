package com.liulangf.tdd;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitingTest {
	private static final transient Logger LOGGER = LoggerFactory.getLogger(WaitingTest.class);
	private Waiting waiting = new Waiting();

	@Test
	public void test() throws Exception {
		LOGGER.info("====HelloWorld===");
		waiting.waiting();
		
		LOGGER.info("==Go Go Go==");
		
		waiting.waiting();
		
		LOGGER.info("===Come on!=");
		
		waiting.waiting();
		
		LOGGER.info("==Test Over!==\n");
	}
	
	@Test
	public void longtest() {
		LOGGER.info("{}", Long.MAX_VALUE);
		LOGGER.info("{}", Integer.MAX_VALUE);
	}

}
