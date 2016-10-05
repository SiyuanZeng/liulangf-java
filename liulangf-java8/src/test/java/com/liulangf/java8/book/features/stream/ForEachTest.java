// ForEachTest.java
package com.liulangf.java8.book.features.stream;

import java.util.List;

import org.junit.Test;

public class ForEachTest {
	
	@Test
	public void test() {
		// Get the list of persons
		List<Person> persons = Person.persons();

		// Print the list
		System.out.println("Before increasing the income: " + persons);

		// Increase the income of females by 10%
		persons.stream()
		       .filter(Person::isFemale)
		       .forEach(p -> p.setIncome(p.getIncome() * 1.10));

		// Print the list again
		System.out.println("After increasing the income: " + persons);
	}
}
