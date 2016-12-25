package com.bvan.jc.oop.textsearcher.spec;

import java.util.Arrays;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class OrSpec<T> implements Spec<T> {

    private final List<Spec<T>> specs;

    public OrSpec(List<Spec<T>> specs) {
        this.specs = specs;
    }

    public OrSpec(Spec<T>... specs) {
        this(Arrays.asList(specs));
    }

    @Override
    public boolean isSatisfiedBy(T content) {
        for (Spec<T> spec : specs) {
            if (spec.isSatisfiedBy(content)) {
                return true;
            }
        }
        return false;
    }
}
