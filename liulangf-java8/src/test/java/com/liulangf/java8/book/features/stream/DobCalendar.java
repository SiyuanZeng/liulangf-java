// DobCalendar.java
package com.liulangf.java8.book.features.stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

import java.time.Month;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class DobCalendar {

	@Test
	public void test() {
		Map<Month, String> dobCalendar = Person
				.persons()
				.stream()
				.collect(
						collectingAndThen(
								groupingBy(p -> p.getDob().getMonth(),
										mapping(Person::getName, joining(", "))),
								result -> {
									// Add missing months
									for (Month m : Month.values()) {
										result.putIfAbsent(m, "None");
									}

									// Return a sorted, unmodifiable map
									return Collections
											.unmodifiableMap(new TreeMap<>(
													result));
								}));

		dobCalendar.entrySet().forEach(System.out::println);
	}
}
