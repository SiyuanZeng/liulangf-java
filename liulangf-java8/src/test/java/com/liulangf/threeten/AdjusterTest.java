package com.liulangf.threeten;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdjusterTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime fm = now.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	
	@Test
	public void mondayTest() {
		LocalDate monday = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		log.info("{}", monday);
	}

}
