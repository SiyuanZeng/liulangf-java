package com.liulangf.threeten;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Test;

/**
 * http://stackoverflow.com/users/38896/jodastephen
 * http://stackoverflow.com/questions/21242110/convert-java-util-date-to-java-time-localdate
 *    --- by JodaStephen
 * 
 * 
 *
 */
public class ConvertBetweenDateAndLocalDateTime {

	@Test
	public void test() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	@Test
	public void convert() {
		//LocalDateTime >> ZonedDateTime
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
		Date output = Date.from(zdt.toInstant());
	}
	
	@Test
	public void dateAndInstant() {
		//The equivalent class to java.util.Date in JSR-310 is Instant
		Date input = new Date();
		Instant instant = input.toInstant();
		Date output = Date.from(instant);
	}

}
