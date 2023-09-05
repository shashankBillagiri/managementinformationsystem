package com.springpractise.managementinformationsystem.util;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilityTest {


    @Test
    public void convertDateTimeToLocalDate() {

        Instant instant = Instant.now();
        LocalDate result = DateUtility.toDate(instant);
        assertNotNull(result);
    }

    @Test
    public void convertDateTimeToExactLocalDate() {

        Instant instant = Instant.parse("2023-09-05T20:08:02.637912Z");
        LocalDate result = DateUtility.toDate(instant);
        assertEquals(LocalDate.of(2023,9,5),result);
    }
}