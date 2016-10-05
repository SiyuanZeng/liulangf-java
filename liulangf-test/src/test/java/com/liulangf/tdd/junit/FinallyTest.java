package com.liulangf.tdd.junit;

import junit.framework.Assert;

import org.junit.Test;

public class FinallyTest {

	@Test
	public void test() {
		Assert.assertFalse(unknown());
	}
	
	private boolean unknown() {
		try {
			return true;
		} finally {
			return false;
		}
	}

}
