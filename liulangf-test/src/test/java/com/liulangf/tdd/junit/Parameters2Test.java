package com.liulangf.tdd.junit;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.liulangf.tdd.HelloWorld;


/**
 * @author LiuYuQing
 */
@RunWith(Parameterized.class)
public class Parameters2Test {
	private HelloWorld hello = new HelloWorld();
	private int expected;
	private int a;
	private int b;

	public Parameters2Test(int a, int b, int expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}
	
	@Parameters
	public static List<Integer[]> param() {
		return Arrays.asList(new Integer[][] {
			{0, 0, 0},
			{1, 1, 2},
			{2, 4, 6},
			{3, 9, 12},
			{4, 16, 20},
			{5, 25, 30},
			{6, 36, 42}
		});
	}
	
	@Test
	public void add() {
		int result = hello.add(a, b);
		Assert.assertEquals(expected, result);
	}

}
