package com.liulangf.threeten;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeIteratStreamTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() {
		final LocalDate start = LocalDate.of(2014, Month.JULY, 1);
		LocalDate end = start.plusDays(10);
		Period p = Period.between(start, end);

		Stream<LocalDate> days = Stream.iterate(start, e -> e.plusDays(1));
		days.limit(p.getDays()).forEach(e -> log.info("{}", e)); 
		
		long dates = ChronoUnit.DAYS.between(start, end);
		log.info("{}", dates);
		
	}

}
