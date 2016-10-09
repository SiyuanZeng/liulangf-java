package com.liulangf.tdd.junit;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Quqing Liu
 */
public class CatTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CatTest.class);
	
	@Before
	public void setUp() {
		LOGGER.info("==[Order.No.1] This is the setUp from CatTest.==");
	}

}
