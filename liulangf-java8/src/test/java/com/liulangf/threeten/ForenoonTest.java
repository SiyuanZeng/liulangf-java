package com.liulangf.threeten;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForenoonTest {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		LocalTime f1 = LocalTime.of(1, 30);
		LocalTime f8 = LocalTime.of(8, 30);
		LocalTime f11 = LocalTime.of(11, 0);
		
		
		LocalTime a15 = LocalTime.of(15, 0);
		LocalTime a17 = LocalTime.of(17, 0);
		LocalTime a20 = LocalTime.of(20, 0);
		
		log.info("{} is {}", f1.format(formatter), f1.isBefore(LocalTime.NOON));
		log.info("{} is {}", f8.format(formatter), f8.isBefore(LocalTime.NOON));
		log.info("{} is {}", f11.format(formatter), f11.isBefore(LocalTime.NOON));
		log.info("{} is {}", a15.format(formatter), a15.isBefore(LocalTime.NOON));
		log.info("{} is {}", a17.format(formatter), a17.isBefore(LocalTime.NOON));
		log.info("{} is {}", a20.format(formatter), a20.isBefore(LocalTime.NOON));
	}

}
