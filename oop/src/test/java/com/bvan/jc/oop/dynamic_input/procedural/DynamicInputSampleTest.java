package com.bvan.jc.oop.dynamic_input.procedural;

import static com.bvan.jc.oop.dynamic_input.procedural.DynamicInputSample.addLast;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class DynamicInputSampleTest {

    @Test
    public void testAddLast() {
        assertThat(addLast(new int[]{10, 5}, 20), is(new int[] {10, 5, 20}));
    }

    @Test
    public void testAddLast_emptyArray() {
        assertThat(addLast(new int[]{}, 10), is(new int[]{10}));
    }
}
