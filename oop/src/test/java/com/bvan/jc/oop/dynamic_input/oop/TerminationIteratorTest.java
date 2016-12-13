package com.bvan.jc.oop.dynamic_input.oop;

import static com.bvan.jc.oop.dynamic_input.oop.IteratorList.listOf;
import java.util.Arrays;
import java.util.Iterator;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class TerminationIteratorTest {

    @Test
    public void inputWithTerminator() {
        Iterator<Integer> initIterator = Arrays.asList(10, 20, 100, 30).iterator();
        Iterator<Integer> terminationIterator = new TerminationIterator<Integer>(initIterator, 100);

        assertThat(listOf(terminationIterator), contains(10, 20));
    }

    @Test
    public void inputWithoutTerminator() {
        Iterator<Integer> initIterator = Arrays.asList(10, 20).iterator();
        Iterator<Integer> terminationIterator = new TerminationIterator<Integer>(initIterator, 100);

        assertThat(listOf(terminationIterator), contains(10, 20));
    }
}
