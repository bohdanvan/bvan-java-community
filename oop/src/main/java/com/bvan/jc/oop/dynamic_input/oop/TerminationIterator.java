package com.bvan.jc.oop.dynamic_input.oop;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author bvanchuhov
 */
public class TerminationIterator<E> implements Iterator<E> {

    private final Iterator<E> iterator;
    private final E terminator;

    private Optional<E> bufferedElem = Optional.empty();

    public TerminationIterator(Iterator<E> iterator, E terminator) {
        this.iterator = iterator;
        this.terminator = terminator;
    }

    public boolean hasNext() {
        if (!iterator.hasNext()) {
            return false;
        }
        E elem = iterator.next();
        if (Objects.equals(terminator, elem)) {
            bufferedElem = Optional.empty();
            return false;
        }
        bufferedElem = Optional.of(elem);
        return true;
    }

    public E next() {
        if (!bufferedElem.isPresent()) {
            throw new NoSuchElementException();
        }
        return bufferedElem.get();
    }
}
