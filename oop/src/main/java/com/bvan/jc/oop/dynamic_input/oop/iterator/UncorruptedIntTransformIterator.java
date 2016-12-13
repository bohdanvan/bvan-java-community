package com.bvan.jc.oop.dynamic_input.oop.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author bvanchuhov
 */
public class UncorruptedIntTransformIterator implements Iterator<Integer> {

    private final Iterator<String> iterator;
    private final Consumer<String> onBadValue;

    private Optional<Integer> bufferedElem = Optional.empty();

    public UncorruptedIntTransformIterator(Iterator<String> iterator) {
        this(iterator, new EmptyConsumer<String>());
    }

    public UncorruptedIntTransformIterator(Iterator<String> iterator, Consumer<String> onBadValue) {
        this.iterator = iterator;
        this.onBadValue = onBadValue;
    }

    public boolean hasNext() {
        if (!iterator.hasNext()) {
            return false;
        }
        String s = iterator.next();
        while (!isInt(s)) {
            onBadValue.accept(s);

            if (!iterator.hasNext()) {
                return false;
            }
            s = iterator.next();
        }

        bufferedElem = Optional.of(Integer.parseInt(s));
        return true;
    }

    public Integer next() {
        if (!bufferedElem.isPresent()) {
            throw new NoSuchElementException();
        }
        return bufferedElem.get();
    }

    private boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static class EmptyConsumer<T> implements Consumer<T> {
        public void accept(T e) {
        }
    }
}
