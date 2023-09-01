package com.springpractise.managementinformationsystem.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateUtility {

    public static String toDate(String timestamp) {

        long time=Long.parseLong(timestamp);

        LocalDate date = Instant.ofEpochMilli(time * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
