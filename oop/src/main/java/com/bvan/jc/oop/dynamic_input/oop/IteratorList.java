package com.bvan.jc.oop.dynamic_input.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class IteratorList<E> implements Iterable<E> {

    private Iterator<E> iterator;

    public static <E> IteratorList<E> listOf(Iterator<E> iterator) {
        return new IteratorList<E>(iterator);
    }

    public IteratorList(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    public List<E> toList() {
        List<E> res = new ArrayList<E>();

        while (iterator.hasNext()) {
            res.add(iterator.next());
        }

        return res;
    }

    public Iterator<E> iterator() {
        return iterator;
    }
}
