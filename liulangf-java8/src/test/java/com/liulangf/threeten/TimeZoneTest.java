package com.liulangf.threeten;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeZoneTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		log.info("{}", ZoneId.systemDefault());
		
		log.info("{}", ZoneOffset.UTC.normalized());
		
		Date currentDate=new Date();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
		Date dateFromLocalDT = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	@Test
	public void betweenTest() {
		LocalDate ld = LocalDate.of(2011, Month.DECEMBER, 19);
		long y = ChronoUnit.YEARS.between(ld, LocalDate.now(ZoneId.systemDefault()));
		log.info("{}", y);
	}
}
