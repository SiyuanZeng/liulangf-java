package com.liulangf.java8;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.SplittableRandom;

import org.fest.util.Arrays;
import org.junit.Test;

public class SpliteratorTest {

	@Test
	public void random() {
		SplittableRandom sr = new SplittableRandom();
		sr.ints(20).forEach(System.out::println);
	}
	
	@Test
	public void first() {
		Integer[] is = Arrays.array(1, 3, 4, 7, 9, 2);
		Spliterators.spliterator(is, 0, 5, Spliterator.SIZED).forEachRemaining(System.out::println);
	}

}
