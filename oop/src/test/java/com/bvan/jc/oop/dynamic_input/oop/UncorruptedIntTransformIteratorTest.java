package com.bvan.jc.oop.dynamic_input.oop;

import static com.bvan.jc.oop.dynamic_input.oop.IteratorList.listOf;
import java.util.Arrays;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class UncorruptedIntTransformIteratorTest {

    @Test
    public void streamWithCorrectElems() {
        Iterator<String> initIterator = Arrays.asList("10", "20").iterator();
        Iterator<Integer> iterator = new UncorruptedIntTransformIterator(initIterator);

        assertThat(listOf(iterator), contains(10, 20));
    }

    @Test
    public void streamWithCorruptedInTheEnd() {
        Iterator<String> initIterator = Arrays.asList("10", "20", "asfasfd").iterator();
        Iterator<Integer> iterator = new UncorruptedIntTransformIterator(initIterator);

        assertThat(listOf(iterator), contains(10, 20));
    }

    @Test
    public void streamWithCorruptedElemInTheMiddle() {
        Iterator<String> initIterator = Arrays.asList("10", "asdfasdf", "20").iterator();
        Iterator<Integer> iterator = new UncorruptedIntTransformIterator(initIterator);

        assertThat(listOf(iterator), contains(10, 20));
    }
}
