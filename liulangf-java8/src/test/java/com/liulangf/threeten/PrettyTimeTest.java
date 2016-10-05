package com.liulangf.threeten;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrettyTimeTest {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void test() {
		LocalDateTime start = LocalDateTime.of(LocalDate.of(2016, 1, 10), LocalTime.of(10, 30));
		LocalDateTime end = LocalDateTime.now();

		Instant startInstant = toInstant(start);
		Instant endInstant = toInstant(end);
		
		long du = endInstant.toEpochMilli() - startInstant.toEpochMilli();
		Duration a = Duration.ofMillis(du);
		
		long days = a.toDays();
		Duration b = a.minusDays(days);
		long hours = b.toHours();
		Duration c = b.minusHours(hours);
		long minutes = c.toMinutes();

		log.info("{} 天", days);
		log.info("{} 小时", hours);
		log.info("{} 分钟", minutes);
	}

	public static Instant toInstant(LocalDateTime dt) {
		return dt.atZone(ZoneId.of("Asia/Shanghai")).toInstant();
	}
}
