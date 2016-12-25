package com.bvan.jc.oop.textsearcher.spec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class Storage<T> implements Iterable<T>, Counter<T>, Filter<T> {

    private final List<T> elems = new ArrayList<>();

    public void add(T elem) {
        elems.add(elem);
    }

    @Override
    public int count(Spec<T> spec) { // GoF: Strategy
        int count = 0;
        for (T elem : elems) {
            if (spec.isSatisfiedBy(elem)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Storage<T> filter(Spec<T> spec) { // GoF: Strategy
        Storage<T> res = new Storage<>();
        for (T elem : elems) {
            if (spec.isSatisfiedBy(elem)) {
                res.add(elem);
            }
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return elems.iterator();
    }
}
