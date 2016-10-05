package com.liulangf.tdd.junit;

/**
 * From <<JUnit in action, 2nd>>.
 * 
 * <p>
 * A unit test examins the behavior of a distinct unit of work. Within a Java application, the 
 * "distinct unit of work" is often(but not always) a single method. By contrast, integration tests
 * and acceptance tests examine how various components interact. 
 * <p>
 * A unit of work is a task that isn't directly dependent on the completion of any other task.
 * <p>
 * Unit tests often focus on testing whether a method follows the terms of its API contract. An API
 * contract is a formal agreement made by the signature of a method.
 * 
 * @author YuQing Liu
 *
 */
public class UnitTest {
	
	/**
	 * Unit testing frameworks should follow several best practices.
	 * <ul>
	 * <li>Each unit test should run independently of all other unit tests.</li>
	 * <li>The framework should detect and report errors test by test.</li>
	 * <li>It should be easy to define which unit tests will run.</li>
	 * </ul>
	 * 
	 * In order for each unit test to be truly independent, each should run in a 
	 * different class instance and ideally in a different class loader instance.
	 * 
	 * The JUnit framework already supports introspecting methods. It also supports 
	 * using a different class instance and class loader instance for each test and 
	 * reports all errors on a test-by-test basis.
	 */
	void unit_testing_framework() {}
	
	/**
	 * A good feature of JUnit:
	 * Separate test class instances and class loaders for each unit test to avoid side effects.
	 * 
	 * Run tests:
	 * java -cp .;\junit-4.10.jar org.junit.runner.JUnitCore XXXTest
	 */
	void testing_with_junit() {}

}
