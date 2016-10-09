package com.liulangf.tdd;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * http://jbrieu.info/leblog/2011/good-unit-test-checklist/
 * 
 * <ul>
 *   <li>My test class is testing one and only one class</li>
 *   <li>My methods are testing one and only one method at a time</li> 
 *   <li>My variables and methods names are explicit</li>
 *   <li>My test cases are easy to read by human</li>
 *   <li>My tests are also testing expected exception with @Test(expected=MyException.class)</li>
 *   <li>My tests don’t need access to database</li>
 *   <li>My tests don’t need access to network resources</li>
 *   <li>My tests respect the usual clean code standards (lenght of lines, cyclomatic complexity,…)</li>
 *   <li>My tests control side effects, limit values (max, min) and null variables (even if it throws an exception)</li>
 *   <li>My tests can be run any time on any place without needing configuration</li>
 *   <li>My tests are concrete (ex. dates are hardwired, not computed every time, strings too…)</li>
 *   <li>My tests use mock to simulate/stub complex class structure or methods</li>
 * </ul>
 * 
 * @author YuQing Liu
 *
 */
public class GoodUnitTestCheckList {
	
	/**
	 * Personnally, instead of using the “@Test(expected=MyException.class)” to test my exception, 
	 * i prefer using the @Rule and ExpectedException to test the exception and the message
	 * 
	 * org.junit.rules.ExpectedException extends Object implements MethodRule;
	 * The ExpectedException Rule allows in-test specification of expected exception types and messages:
	 * <pre>
	 * </pre>
	 * 
	 */
	void testExceptionUsingRule() {
	}
	
	/**
	 * I would add:: The test case tests one and only one feature (not method) at a time.
	 */
	void onlyOneFeaturePerTime() {
	}
	
}

class HasExpectedExceptionTest {
	 @Rule
     public ExpectedException thrown= ExpectedException.none();

     @Test
     public void throwsNothing() {
         //no exception expected, none thrown: passes.
     }

     @Test
     public void throwsNullPointerException() {
             thrown.expect(NullPointerException.class);
             throw new NullPointerException();
     }

     @Test
     public void throwsNullPointerExceptionWithMessage() {
             thrown.expect(NullPointerException.class);
             thrown.expectMessage("happened?");
             //thrown.expectMessage(startsWith("What"));
             throw new NullPointerException("What happened?");
     }
}
