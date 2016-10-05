// CollectJoiningTest.java
package com.liulangf.java8.book.features.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class CollectJoiningTest {
	@Test
	public void test() {
		List<Person> persons = Person.persons();
		String names = persons.stream()
		                      .map(Person::getName)
		                      .collect(Collectors.joining());

		String delimitedNames = persons.stream()
		                               .map(Person::getName)
		                               .collect(Collectors.joining(", "));

		String prefixedNames = persons.stream()
			.map(Person::getName)
			.collect(Collectors.joining(", ", "Hello ", ". Goodbye."));

		System.out.println("Joined names: " + names);
		System.out.println("Joined, delimited names: " + delimitedNames);
		System.out.println(prefixedNames);
	}
}
