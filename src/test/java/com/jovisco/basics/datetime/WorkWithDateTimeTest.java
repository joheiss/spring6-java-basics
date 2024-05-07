package com.jovisco.basics.datetime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class WorkWithDateTimeTest {

    @Test
    void testDateTimeCreation() {

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println(currentDate + ", " + currentTime + ", " + currentDateTime);
        System.out.flush();

        assertTrue(currentDate.equals(LocalDate.now()));
    }

    @Test
    void testDateTimeCalculation() {

        LocalDate currentDate = LocalDate.now();

        var nextWeek = currentDate.plusDays(7);
        System.out.println(currentDate + ", " + nextWeek);
        System.out.flush();

        assertTrue(currentDate.isBefore(nextWeek));
    }

    @Test
    void testDateTimeFormatting() {

        var currentDateTime = LocalDateTime.now();

        var formattedDate = currentDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        System.out.println(currentDateTime + ", " + formattedDate);
        System.out.flush();

        assertFalse(formattedDate.isEmpty());
    }

}
