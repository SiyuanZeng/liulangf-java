package com.liulangf.tdd.junit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiuYuQing
 */
public class HelloWorldTest {
	
	public HelloWorldTest() {
		LOGGER.info("new HelloWorldTest()");
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldTest.class);
	private int x = 1;
	private int y = 1;

	//Should be static
	@BeforeClass public 
	static void beforeTests() {
		LOGGER.info("@Before all tests begin.");
	}
	
	//more @Before
	@Before public 
	void init2() {
		LOGGER.info("@Before : init2()");
	}
	
	@Before public 
	void init1() {
		LOGGER.info("@Before : init1()");
	}
	
	
	@Test 
	public void addition() {
		int z = x + y;
		Assert.assertEquals(2, z);
	}
	
	@Test 
	public void sub() {
		Assert.assertEquals(0, x - y);
	}
	
	@Test
	@Ignore("Not ready yet")
	public void notReady() {
		LOGGER.info("You can not see me!!!!!");
	}
	
	//testing exceptions
	/**
	 * Not only is this method ugly, but it tends to trip up 
	 * code-coverage tools because whether the tests pass or fail, 
	 * some code isn't executed. 
	 * In JUnit 4, you can now write the code that throws 
	 * the exception and use an annotation to declare 
	 * that the exception is expected
	 */
	@Test public 
	void testDivisionByZero() {
		try {
			int n = 2 / 0;
			Assert.fail("Divide by zero");
		} catch (ArithmeticException success) {
			Assert.assertNotNull(success.getMessage());
		}
	}
	
	//Testing exception
	@Test(expected=ArithmeticException.class)
	public void divideByZero() {
		int a = 2 / 0;
	}
	
	//test timeout [milliseconds]
	@Test(timeout=500)
	public void longtimeTest() {
		LOGGER.info("hello world");
	}
	
	//more @After
	@After public 
	void shutDown1() {
		LOGGER.info("@After shutDown1");
	}
	
	@After public 
	void shutDown2() {
		LOGGER.info("@After shutDown2");
	}
	
	//Should be static
	@AfterClass public static 
	void afterTests() {
		LOGGER.info("@After all tests done.");
	}

}
