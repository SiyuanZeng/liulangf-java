package com.liulangf.tdd.junit;

import org.junit.Test;

public class HelloWorldJUnit {
	public HelloWorldJUnit(String name) {
	}

	@Test
	public void test() {
		org.junit.Assert.assertThat(8, org.hamcrest.CoreMatchers.is(8));
	}

}
