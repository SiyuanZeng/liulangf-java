package com.liulangf.tdd.junit;

import org.hamcrest.Matcher;
import org.junit.Assert;

/**
 * http://junit.sourceforge.net/doc/ReleaseNotes4.4.html
 *
 * @author Quqing Liu
 */
public class JUnitFeatures {
	
	/**
	 * From <<Growing Object-Oriented Software, Guided by Tests>>
     * A test fixture is the fixed state that exists at the start of a test.
     * A test fixture ensures that a test is repeatable-every time a test is run it starts 
     * in the same state so it should produce the same results. A fixture may be set up before 
     * the test runs and torn down after it has finished.
	 */
	void testFixture() {
	}

	/**
	 * The way JUnit reflects on a class to find tests and then runs those tests is controlled
	 * by a test runner. The runner used for a class can be configured with the @RunWith annotation.
	 * JUnit provides a small library of test runners.
	 * 
	 * The jMock library uses a custom test runner to automatically verify mock objects at the end
	 * of the test, before the test fixture is torn down.
	 */
	void testRunners() {
	}
	
	/**
	 * Hamcrest is a framework for writing declarative match criteria.
	 * A Hamcrest matcher reports whether a given object matches some criteria, can describe its criteria,
	 * and can describe why an object does not meet its criteria.
	 * 
	 * Note: Hamcrest it is not a testing library: it just happens that matchers are very useful for testing.
	 */
	void hamcrestMatchers() {
		String actual = "";
		Assert.assertTrue(containingString("").matches(actual));

		//
		practice(actual);
	}
	
	/**
	 * In practice, we use matchers in combination with JUnit's assertThat(), which uses matcher's
	 * self-describing features to make clear exactly what went wrong when an assertion fails.
	 */
	private void practice(String actual) {
		Assert.assertThat(actual, containingString(""));
	}
	
	/**
	 * Matchers are not usually instantiated directly. Instead, Hamcrest provides static factory
	 * methods for all of its matchers to make the code that creates matchers more readable.
	 * 
	 * @param exptected
	 * @return
	 */
	private static Matcher<String> containingString(String exptected) {
	    return null;
//		return new Matcher<String>() {
//			public boolean matches(Object item) {
//				return true;
//			}
//			public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
//			}
//			public void describeTo(Description description) {
//			}
//		};
	}

}
