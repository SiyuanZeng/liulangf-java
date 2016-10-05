package com.liulangf.tdd.junit;

/**
 * @author YuQing Liu
 *
 */
public class JUnit_test_runner {
	
	
	/**
	 * @RunWith(value=org.junit.internal.runners.JUnit38ClassRunner.class)
	 * <ul>
	 * <li>org.junit.internal.runners.JUnit38ClassRunner</li>
	 * <li>org.junit.runners.JUnit4</li>
	 * <li>org.junit.runners.Parameterized</li>
	 * <li>org.junit.runners.Suite</li>
	 * </ul>
	 */
	void junit4_test_runners() {}
	
	/**
	 * To make running tests as quick and easy as possible, JUnit provides a façade 
	 * (org.junit.runner.JUnitCore), which operates with any of the test runners. 
	 * JUnit designed this façade to execute your tests and gather results and statistics.
	 * 
	 * The JUnit façade determines which runner to use for running your tests. It supports 
	 * running JUnit 3.8 tests, JUnit 4 tests, and a mixture of both.
	 */
	void junitCore_facade() {}

}
