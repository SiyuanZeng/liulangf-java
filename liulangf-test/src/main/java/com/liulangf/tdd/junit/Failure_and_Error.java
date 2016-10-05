package com.liulangf.tdd.junit;

/**
 * From <<JUnit Recipes>>. Chapter 1.2.6: The difference between failures and errors.
 * 
 * 
 * @author YuQing Liu
 *
 */
public interface Failure_and_Error {
	
	/**
	 * java.lang.Exception extends Throwable;
	 * java.lang.Error extends Throwable;
	 * 
	 * An exception indicates conditions that a reasonable application might want to catch.
	 * An Error indicates serious problems that a reasonable application should not try to catch.
	 */
	void exception_and_error_in_java();
	
	/**
	 * <p>
	 * You normally don’t want the Java code that you write to throw errors, but rather only exceptions. 
	 * General practice leaves the throwing of errors to the Java Virtual Machine itself, because an error 
	 * indicates a low-level, unrecoverable problem, such as not being able to load a class. This is the kind of 
	 * stuff from which we mortals cannot be expected to recover. For that reason, it might seem strange for 
	 * JUnit to throw an error to indicate an assertion failure.
	 * <p>
	 * JUnit throws an error rather than an exception because in Java, errors are unchecked; therefore, not 
	 * every test method needs to declare that it might throw an error.You might suppose that a RuntimeException 
	 * would have done the same job, but if JUnit threw the kinds of exceptions your production code might throw,
	 * then JUnit tests might interfere with your production. Such interference would diminish JUnit’s value.
	 * <p>
	 * When your test contains a failed assertion, JUnit counts that as a failed test; but when your test throws 
	 * an exception (and does not catch it), JUnit counts that as an error. The difference is subtle, but useful: 
	 * a failed assertion usually indicates that the production code is wrong, but an error indicates that there is 
	 * a problem either with the test itself or in the surrounding environment. Perhaps your test expects the wrong 
	 * exception object or incorrectly tries to invoke a method on a null reference. Perhaps a disk is full, or a 
	 * network connection is unavailable, or a file is not found. JUnit cannot conclude that your production code is 
	 * at fault, so it throws up its hands and says, “Something went wrong. I can’t tell whether the test would pass 
	 * or fail. Fix the problem and run this test again.” That is the difference between a failure and an error.
	 * <p>
	 * JUnit’s test runners report the results of a test run in this format: “78 run, 2 failures, 1 error.”
	 * From this you can conclude that 75 tests passed, 2 failed, and 1 was inconclusive. Our recommendation is to 
	 * investigate the error first, fix the problem, and then run the tests again. It might be that with the error 
	 * out of the way, all the tests pass!
	 */
	void difference_between_failure_error();

}
