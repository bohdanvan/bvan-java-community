package com.bvan.jc.oop.textsearcher.spec;

/**
 * @author bvanchuhov
 */
public interface Filter<T> {
    Filter<T> filter(Spec<T> spec);
}
