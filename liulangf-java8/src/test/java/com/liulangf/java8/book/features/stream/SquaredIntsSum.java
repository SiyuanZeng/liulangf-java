// SquaredIntsSum.java
package com.liulangf.java8.book.features.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SquaredIntsSum {
	
	@Test
	public void test() {
		// Get a list of integers from 1 to 5
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Compute the sum of the squares of all odd integers in the list
		int sum = numbers.stream()
		                 .filter(n -> n % 2 == 1)
		                 .map(n -> n * n)
		                 .reduce(0, Integer::sum);
		
		System.out.println("Sum = " + sum);
	}
}
