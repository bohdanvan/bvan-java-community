package com.bvan.jc.oop.textsearcher.spec;

/**
 * @author bvanchuhov
 */
public interface Counter<T> {
    int count(Spec<T> spec);
}
