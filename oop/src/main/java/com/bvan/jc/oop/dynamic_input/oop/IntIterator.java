package com.bvan.jc.oop.dynamic_input.oop;

import java.io.Reader;
import java.util.Iterator;

/**
 * @author bvanchuhov
 */
public class IntIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public IntIterator(Reader reader) {
        iterator =
                new TerminationIterator<Integer>(
                        new UncorruptedIntTransformIterator(
                                new ReaderIterator(reader)
                        )
                        , null);
    }

    public IntIterator(Reader reader, int terminator) {
        iterator =
                new TerminationIterator<Integer>(
                        new UncorruptedIntTransformIterator(
                                new ReaderIterator(reader)
                        )
                        , terminator);
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Integer next() {
        return iterator.next();
    }
}
