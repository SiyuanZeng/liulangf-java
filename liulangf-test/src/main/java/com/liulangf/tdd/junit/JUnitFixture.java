package com.liulangf.tdd.junit;

import org.junit.Test;

/**
 * Junit 3.X
 *     junit.framework.*;
 *     junit.runner.*;
 * 
 * Junit 4.x
 *     org.junit.internal.*;
 *     org.junit.matchers.*;
 *     org.junit.rules.*;
 *     org.junit.runner.*;
 *     org.junit.runners.*;
 *     org.hamcrest.*;
 * 
 * @author YuQing Liu
 *
 */
public interface JUnitFixture {
	
	/**
	 * org.junit.After;
	 * org.junit.AfterClass;
	 * org.junit.Before;
	 * org.junit.BeforeClass;
	 * org.junit.ClassRule;
	 * org.junit.Ignore;
	 * org.junit.Rule;
	 * org.junit.Test;
	 * org.junit.runner.RunWith;
	 * org.junit.runners.SuiteClasses;
	 */
	void annotations();
	
	/**
	 * These three objects form the backbone of the JUnit framework.
	 * <ul>
	 * <li>test class</li>
	 * <li>test suite</li>
	 * <li>test runner</li>
	 * </ul>
	 */
	void core_concept();
	
	/**
	 * 1. @ort.junit.Test;
	 * 2. public 
	 * 3. void
	 * 4. no arguments
	 * <p>
	 * Because each test method runs on a new test class instance, 
	 * we can’t reuse instance variable values across test methods.
	 * 
	 * To run this method JUnit constructs a new instance of the containing class and then invokes the annotated method.
	 */
	@Test
	public void test_method();

	/**
	 * Test class(or TestCase or test case): A class that contains one or more tests represented by 
	 * methods annotated with @Test. Use a test class to group together tests that exercise common behaviors.
	 */
	void test_class();
	
	/**
	 * The Runner class runs tests. 
	 * JUnit uses a test runner on your behalf to manage the lifecycle of your test class, 
	 * including creating the class, invoking tests, and gathering results.
	 */
	void test_runner();
}