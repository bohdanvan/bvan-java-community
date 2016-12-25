package com.bvan.jc.oop.textsearcher.textcontent;

/**
 * @author bvanchuhov
 */
public interface TextContent {
    boolean containsInTitle(String key);
    boolean containsInText(String key);
}
