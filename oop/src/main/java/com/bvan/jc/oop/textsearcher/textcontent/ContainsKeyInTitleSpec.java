package com.bvan.jc.oop.textsearcher.textcontent;

import com.bvan.jc.oop.textsearcher.spec.Spec;

/**
 * @author bvanchuhov
 */
public class ContainsKeyInTitleSpec implements Spec<TextContent> {

    private final String key;

    public ContainsKeyInTitleSpec(String key) {
        this.key = key;
    }

    @Override
    public boolean isSatisfiedBy(TextContent content) {
        return content.containsInTitle(key);
    }
}
