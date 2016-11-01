package com.bvan.jc.employee.util;

import java.util.Random;

/**
 * @author bvanchuhov
 */
public final class IdGenerator {

    private static Random random = new Random();

    public static long generateId() {
        return random.nextLong();
    }
}
