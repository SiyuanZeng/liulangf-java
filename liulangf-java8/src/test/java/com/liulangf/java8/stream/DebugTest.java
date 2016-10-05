package com.liulangf.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class DebugTest {

	@Test
	public void test() {
		Stream<String> s = Arrays.asList("A", "B", "C", "D").stream();
		s = s.filter(e -> e.charAt(0) > 'A');
		s = s.map(String::toLowerCase);
		s.forEach(System.out::println);
	}

	@Test
	public void peekTest() {
		int sum = Stream.of(1, 2, 3, 4, 5)
				.peek(e -> System.out.println("Taking int " + e))
				.filter(n -> n % 2 == 1)
				.peek(e -> System.out.println("Fiter int " + e))
				.map(n ->n * n)
				.peek(e -> System.out.println("Map int " + e + "\n"))
				.reduce(0, Integer::sum);
		
		System.out.println("Sum = " + sum);
	}
}
