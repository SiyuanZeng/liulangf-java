// CollectIntoMapTest.java
package com.liulangf.java8.book.features.stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectIntoMapTest {
	public static void main(String[] args) {
		Map<Person.Gender, Person> highestEarnerByGender = 
          Person.persons()
			.stream()
			.collect(Collectors.toMap(Person::getGender, Function.identity(),
				(oldPerson, newPerson) -> 
			    newPerson.getIncome() > oldPerson.getIncome()?newPerson:oldPerson));

		System.out.println(highestEarnerByGender);
	}
}
