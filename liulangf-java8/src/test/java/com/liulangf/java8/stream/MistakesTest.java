package com.liulangf.java8.stream;

import java.util.stream.IntStream;

import org.junit.Test;

public class MistakesTest {

	@Test(expected = java.lang.IllegalStateException.class)
	public void test() {
		IntStream stream = IntStream.of(1, 2, 3);
		stream.forEach(System.out::println);
		stream.forEach(System.out::println);
	}

}
