package com.bvan.jc.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class ReverserTest {

    @Test
    public void testReverse_arrayWithEvenSize() {
        int[] a = {2, 7, 8, 1};
        Reverser.reverse(a);
        assertThat(a, is(new int[]{1, 8, 7, 2}));
    }

    @Test
    public void testReverse_arrayWithOddSize() {
        int[] a = {2, 7, 8, 1, 9};
        Reverser.reverse(a);
        assertThat(a, is(new int[]{9, 1, 8, 7, 2}));
    }

    @Test
    public void testReverse_emptyArray() {
        int[] a = {};
        Reverser.reverse(a);
        assertThat(a, is(new int[]{}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverse_nullArray() {
        Reverser.reverse(null);
    }
}
