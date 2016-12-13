package com.bvan.jc.oop.dynamic_input.oop;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class IteratorListTest {

    @Test
    public void testIteratorList() {
        List<Integer> initList = Arrays.asList(10, 20, 30);
        Iterator<Integer> iterator = initList.iterator();

        List<Integer> list = new IteratorList<Integer>(iterator).toList();
        assertThat(list, is(initList));
    }
}
