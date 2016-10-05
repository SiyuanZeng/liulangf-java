// IncomeStatsByGender.java
package com.liulangf.java8.book.features.stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;

import java.util.DoubleSummaryStatistics;
import java.util.Map;

import org.junit.Test;

public class IncomeStatsByGender {
	
	@Test
	public void test() {
		Map<Person.Gender, DoubleSummaryStatistics> incomeStatsByGender = 
			Person.persons()
			      .stream()	
			      .collect(groupingBy(Person::getGender, 
			                          summarizingDouble(Person::getIncome)));

		System.out.println(incomeStatsByGender);
	}
}
