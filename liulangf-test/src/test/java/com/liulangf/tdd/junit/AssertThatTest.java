package com.liulangf.tdd.junit;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.matchers.JUnitMatchers.both;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.either;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

/**
 * import static org.hamcrest.CoreMatchers.*;
 * import static org.junit.matchers.JUnitMatchers.*; 
 * 
 * https://github.com/junit-team/junit/wiki/Assertions
 * 
 * @author YuQing Liu
 */
public class AssertThatTest {
	
	@Test
	public void assertThateTest() {
		org.junit.Assert.assertThat(3, is(3));
		org.junit.Assert.assertThat(4, is(not(3)));
		org.junit.Assert.assertThat("hello world", either(containsString("hello")).or(containsString("world")));
	}
	
	  @Test
	  public void testAssertArrayEquals() {
	    byte[] expected = "trial".getBytes();
	    byte[] actual = "trial".getBytes();
	    org.junit.Assert.assertArrayEquals("failure - byte arrays not same", expected, actual);
	  }

	  @Test
	  public void testAssertEquals() {
	    org.junit.Assert.assertEquals("failure - strings are not equal", "text", "text");
	  }

	  @Test
	  public void testAssertFalse() {
	    org.junit.Assert.assertFalse("failure - should be false", false);
	  }

	  @Test
	  public void testAssertNotNull() {
	    org.junit.Assert.assertNotNull("should not be null", new Object());
	  }

	  @Test
	  public void testAssertNotSame() {
	    org.junit.Assert.assertNotSame("should not be same Object", new Object(), new Object());
	  }

	  @Test
	  public void testAssertNull() {
	    org.junit.Assert.assertNull("should be null", null);
	  }

	  @Test
	  public void testAssertSame() {
	    Integer aNumber = Integer.valueOf(768);
	    org.junit.Assert.assertSame("should be same", aNumber, aNumber);
	  }

	  // JUnit Matchers assertThat
	  @Test
	  public void testAssertThatBothContainsString() {
	    org.junit.Assert.assertThat("albumen", both(containsString("a")).and(containsString("b")));
	  }

	  @Test
	  public void testAssertThathasItemsContainsString() {
	    org.junit.Assert.assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	  }

	  @Test
	  public void testAssertThatEveryItemContainsString() {
	    org.junit.Assert.assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	  }

	  // Core Hamcrest Matchers with assertThat
	  @Test
	  public void testAssertThatHamcrestCoreMatchers() {
		  org.junit.Assert.assertThat("good", allOf(equalTo("good"), startsWith("good")));
		  org.junit.Assert.assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		  org.junit.Assert.assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		  org.junit.Assert.assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		  org.junit.Assert.assertThat(new Object(), not(sameInstance(new Object())));
	  }

	  @Test
	  public void testAssertTrue() {
	    org.junit.Assert.assertTrue("failure - should be true", true);
	  }

}
