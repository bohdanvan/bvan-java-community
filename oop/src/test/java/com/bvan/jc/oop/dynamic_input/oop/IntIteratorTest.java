package com.bvan.jc.oop.dynamic_input.oop;

import static com.bvan.jc.oop.dynamic_input.oop.IteratorList.listOf;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class IntIteratorTest {

    @Test
    public void steamWithTerminatorInt() {
        Reader reader = new StringReader("10 20 100 1 2 3");
        Iterator<Integer> iterator = new IntIterator(reader, 100);

        assertThat(listOf(iterator), contains(10, 20));
    }

    @Test(expected = NoSuchElementException.class)
    public void nextAfterIteratorFinishingThrowsException() {
        Reader reader = new StringReader("10");
        Iterator<Integer> iterator = new IntIterator(reader, 100);

        iterator.next();
        iterator.next();
    }

    @Test
    public void streamWithoutTerminator() {
        Reader reader = new StringReader("10 20");
        Iterator<Integer> iterator = new IntIterator(reader);

        assertThat(listOf(iterator), contains(10, 20));
    }

    @Test
    public void streamWithIncorrectInt() {
        Reader reader = new StringReader("10 asfasdf 20");
        Iterator<Integer> iterator = new IntIterator(reader);

        assertThat(listOf(iterator), contains(10, 20));
    }
}
