package com.bvan.jc.oop.dynamic_input.partial_oop;

import com.bvan.jc.oop.dynamic_input.oop.DynamicArray;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class DynamicArrayTest {

    @Test
    public void testAddOneElem() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        assertThat(dynamicArray.toString(), is("[1]"));
    }

    @Test
    public void testAddNoElems() {
        DynamicArray dynamicArray = new DynamicArray();
        assertThat(dynamicArray.toString(), is("[]"));
    }

    @Test
    public void testAdd() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(10);
        dynamicArray.add(50);
        dynamicArray.add(20);
        assertThat(dynamicArray.toString(), is("[10, 50, 20]"));
    }
}
