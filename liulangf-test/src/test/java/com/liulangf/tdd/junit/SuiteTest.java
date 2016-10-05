package com.liulangf.tdd.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiuYuQing
 */
@RunWith(Suite.class)
@SuiteClasses({
	HelloWorldTest.class,
	ParametersTest.class,
	Parameters2Test.class
})
public class SuiteTest {
	
	private static Logger logger = LoggerFactory.getLogger(SuiteTest.class);
	
	@BeforeClass
	public static void setUp() {
		logger.info("=============SuiteTest.BeforeClass setUp().=====================");
	}

	@AfterClass
	public static void tearDown() {
		logger.info("=============SuiteTest.AfterClass tearDown().=====================");
	}
}
