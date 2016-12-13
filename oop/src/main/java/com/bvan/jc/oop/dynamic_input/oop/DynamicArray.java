package com.bvan.jc.oop.dynamic_input.oop;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author bvanchuhov
 */
public class DynamicArray {

    public static final int GROWTH_FACTOR = 2;

    private int[] array;
    private int size;

    public DynamicArray() {
        array = new int[10];
        size = 0;
    }

    public void add(int elem) {
        if (array.length == size) {
            array = Arrays.copyOf(array, array.length * GROWTH_FACTOR);
        }
        array[size++] = elem;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(array[i]));
        }
        return joiner.toString();
    }
}
