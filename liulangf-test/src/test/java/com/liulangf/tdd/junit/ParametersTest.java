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
 * When a class is annotated with &#064;RunWith, 
 * JUnit will invoke the class referenced to run the tests instead of the default runner. 
 * To use a parameterized test case, you need to use the runner org.junit.runners.Parameterized. 
 * To know which parameters to use, the test case needs a public static method (here data() 
 * but the name is irrelevant) that returns a Collection and is annotated with @Parameters. 
 * You also need a public constructor that takes these parameters.
 * 
 * This class is a parameterized test case. 
 * It uses the values define in the collection as a parameter.
 * 
 * @author LiuYuQing
 */
@RunWith(Parameterized.class)
public class ParametersTest {
	private HelloWorld hello = new HelloWorld();
	private int expected;
	private int param;
	
	public ParametersTest(int param, int expected) {
		this.expected = expected;
		this.param = param;
	}
	
	//@Parameters public static method and returns Collection 
	@Parameters
	public static List<Integer[]> param() {
		return Arrays.asList(new Integer[][] {
			{0, 0},
			{1, 1},
			{2, 4},
			{3, 9},
			{4, 16},
			{5, 25},
			{6, 36}
		});
	}

	@Test
	public void square() {
		int result = hello.square(param);
		Assert.assertEquals(expected, result);
	}
	
}
