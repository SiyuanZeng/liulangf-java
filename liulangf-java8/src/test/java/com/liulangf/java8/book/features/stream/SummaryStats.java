// SummaryStats.java
package com.liulangf.java8.book.features.stream;

import java.util.DoubleSummaryStatistics;

import org.junit.Test;

public class SummaryStats {
	
	@Test
	public void test() {
		DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
		stats.accept(100.0);
		stats.accept(500.0);
		stats.accept(400.0);
		
		// Get stats
		long count = stats.getCount();
		double sum = stats.getSum();
		double min = stats.getMin();
		double avg = stats.getAverage();
		double max = stats.getMax();
		
		System.out.printf("count=%d, sum=%.2f, min=%.2f, average=%.2f, max=%.2f%n", 
			count, sum, min, avg, max);

	}
}
