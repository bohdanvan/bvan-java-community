package com.bvan.jc.chat4;

/**
 * @author bvanchuhov
 */
public final class Reverser {

    private Reverser() {}

    /**
     * Reverses array.<br/>
     * {7, 4, 9, 2} -> {2, 9, 4, 7}
     */
    public static void reverse(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("null array");
        }

        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            swap(array, i, j);
        }
    }

    private static void swap(int[] array, int i, int j) {
        checkIndex(array, i);
        checkIndex(array, j);
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void checkIndex(int[] array, int i) {
        if (i < 0 || i >= array.length) {
            throw new IndexOutOfBoundsException("illegal index: " + i);
        }
    }
}
