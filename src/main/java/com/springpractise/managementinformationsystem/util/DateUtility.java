package com.springpractise.managementinformationsystem.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public final class DateUtility {

    public static LocalDate toDate(Instant joiningDateTime) {

        return joiningDateTime.atZone(ZoneId.of("America/Chicago")).toLocalDate();
    }
}
