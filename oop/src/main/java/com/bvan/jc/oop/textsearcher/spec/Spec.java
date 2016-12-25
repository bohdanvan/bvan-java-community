package com.bvan.jc.oop.textsearcher.spec;

/**
 * @author bvanchuhov
 */
public interface Spec<T> {

    boolean isSatisfiedBy(T content);
}
