package com.liulangf.threeten;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstanceTest {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() {
		// Date << Instant << LocalDateTime
		LocalDateTime dt = LocalDateTime.now();
		Instant point = dt.toInstant(ZoneOffset.UTC);
		Date date = Date.from(point);
		
		//LocalDateTime << Instant << Date
		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		
		//Date << Instant << LocalDate
		Date d = Date.from(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC));
		
		//LocalDate << Instance << Date
		LocalDate ld = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	
	@Test
	public void timeZoneTest() {
		ZoneId defaultZone = ZoneId.systemDefault();
		log.info("{}", defaultZone);
	}
}
