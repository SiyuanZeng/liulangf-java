package com.liulangf.threeten;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;

import org.junit.Test;

/**
 * User: Bill Bejeck
 * Date: 3/13/14
 * Time: 9:18 PM
 */
public class DateFormatTest {

    private LocalDate localDate = LocalDate.parse("2014-03-13");
    private DateTimeFormatter fullFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private DateTimeFormatter longFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    private DateTimeFormatter mediumFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    private DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

    private DateTimeFormatter fullDateTimeFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
    private DateTimeFormatter longDateTimeFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
    private DateTimeFormatter mediumDateTimeFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    private DateTimeFormatter shortDateTimeFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

    //9月21日 PM 14:00
    private DateTimeFormatter chineseDateTimeFormat2 = DateTimeFormatter.ofPattern("MM月dd日 a HH:mm", java.util.Locale.ENGLISH);
    
    public static final DateTimeFormatter chineseDateTimeFormat;
    static {
    	chineseDateTimeFormat = new DateTimeFormatterBuilder()
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral('月')
                .appendValue(DAY_OF_MONTH, 2)
                .appendLiteral('日')
                .toFormatter();
    }

    @Test
    public void test_date_format() {
        assertThat(localDate.format(fullFormat), is("Thursday, March 13, 2014"));
        assertThat(localDate.format(longFormat), is("March 13, 2014"));
        assertThat(localDate.format(mediumFormat), is("Mar 13, 2014"));
        assertThat(localDate.format(shortFormat), is("3/13/14"));
    }

    @Test
    public void test_date_time_format() {
        LocalTime localTime = LocalTime.parse("14:23:33");
        LocalDateTime dateTime =  localDate.atTime(localTime);

        assertThat(dateTime.format(mediumDateTimeFormat), is("Mar 13, 2014 2:23:33 PM"));
        assertThat(dateTime.format(shortDateTimeFormat), is("3/13/14 2:23 PM"));

        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("America/New_York"));
        assertThat(zonedDateTime.format(fullDateTimeFormat),is("Thursday, March 13, 2014 2:23:33 PM EDT"));
        assertThat(zonedDateTime.format(longDateTimeFormat),is("March 13, 2014 2:23:33 PM EDT"));
    }
    
    @Test
    public void testChinese() {
    	System.out.println(LocalDateTime.now().format(chineseDateTimeFormat2));
    }
}
