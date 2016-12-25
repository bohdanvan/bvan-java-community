package com.bvan.jc.oop.textsearcher.spec;

import java.util.Arrays;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class AndSpec<T> implements Spec<T> { // GoF: Decorator, Composite

    private final List<Spec<T>> specs;

    public AndSpec(List<Spec<T>> specs) {
        this.specs = specs;
    }

    public AndSpec(Spec<T>... specs) {
        this(Arrays.asList(specs));
    }

    @Override
    public boolean isSatisfiedBy(T content) {
        for (Spec<T> spec : specs) {
            if (!spec.isSatisfiedBy(content)) {
                return false;
            }
        }
        return true;
    }
}
