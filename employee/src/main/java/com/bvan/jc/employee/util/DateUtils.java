package com.bvan.jc.employee.util;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author bvanchuhov
 */
public final class DateUtils {

    private DateUtils() {}

    public static long getTimestamp(int year, int month, int dayOfMonth) {
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, dayOfMonth);
        Date date = calendar.getTime();
        return date.getTime();
    }
}
