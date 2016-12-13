package com.bvan.jc.oop.dynamic_input.oop;

import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author bvanchuhov
 */
public class ReaderIterator implements Iterator<String> {

    private final Scanner scanner;

    public ReaderIterator(Reader reader) {
        scanner = new Scanner(reader);
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public String next() {
        return scanner.next();
    }
}
