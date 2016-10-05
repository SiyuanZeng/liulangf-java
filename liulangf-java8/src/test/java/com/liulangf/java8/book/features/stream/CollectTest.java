// CollectTest.java
package com.liulangf.java8.book.features.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class CollectTest {

	@Test
	public void test() {
		List<String> sortedNames = Person.persons().stream()
				.map(Person::getName)
				.sorted()
				.collect(Collectors.toList());
		System.out.println(sortedNames);
	}
}
