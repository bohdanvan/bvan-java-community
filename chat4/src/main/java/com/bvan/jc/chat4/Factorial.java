package com.bvan.jc.chat4;

import java.math.BigInteger;

/**
 * @author bvanchuhov
 */
public final class Factorial {

    private Factorial() {}

    /**
     * n! = 1 * 2 * 3 * ... * n, n >= 0
     * 3! = 1 * 2 * 3 = 6
     * 0! = 1
     */
    public static BigInteger factorial(int n) {
        checkFactorialArg(n);

        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res;
    }

    private static void checkFactorialArg(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("negative arg: " + n);
        }
    }
}
