package com.liulangf.threeten;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;
/**
 * User: Bill Bejeck
 * Date: 3/12/14
 * Time: 10:34 PM
 */
public class InstantTest {

    @Test
    public void test_create_instant()throws Exception {
        Instant start = Instant.now();
        Thread.sleep(2000l);
        Instant end = Instant.now();
        long difference = start.until(end, ChronoUnit.SECONDS);
        assertThat(difference,is(2L));
    }

    @Test
    public void test_ensure_completed_by() throws Exception {
        Instant start = Instant.now();
        Instant deadline = start.plusSeconds(2);
        //Simulated task
        Thread.sleep(1500);
        Instant simulateCompletedTask = Instant.now();
        assertThat(simulateCompletedTask.isBefore(deadline),is(true));
    }
    
    @Test
    public void instantTest() {
    	System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    	LocalDateTime ldt = LocalDateTime.parse("2014-10-03T09:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    	System.out.println(ldt.toEpochSecond(ZoneOffset.UTC));//1412328600000
    	
    	
    }


}
