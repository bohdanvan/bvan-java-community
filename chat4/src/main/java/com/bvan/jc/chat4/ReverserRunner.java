package com.bvan.jc.chat4;

import java.util.Arrays;

/**
 * @author bvanchuhov
 */
public class ReverserRunner {

    public static void main(String[] args) {
        testWithEvenSize();
        testWithOddSize();
        testWithEmptyArray();
        testWithNullArray();
    }

    private static void testWithNullArray() {
        try {
            int[] a = null;
            Reverser.reverse(a);
            System.out.println(false);
        } catch (IllegalArgumentException e) {
            System.out.println(true);
        } catch (Throwable e) {
            System.out.println(false + ": " + e);
        }
    }

    private static void testWithEmptyArray() {
        int[] a = {};
        Reverser.reverse(a);

        System.out.println(Arrays.equals(a, new int[]{}));
    }

    private static void testWithEvenSize() {
        int[] a = {2, 7, 8, 1};
        Reverser.reverse(a);

        System.out.println(Arrays.equals(a, new int[]{1, 8, 7, 2}));
    }

    private static void testWithOddSize() {
        int[] a = {2, 7, 8, 1, 9};
        Reverser.reverse(a);

        System.out.println(Arrays.equals(a, new int[]{9, 1, 8, 7, 2}));
    }
}
