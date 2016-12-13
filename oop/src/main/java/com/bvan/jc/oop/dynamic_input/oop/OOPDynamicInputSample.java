package com.bvan.jc.oop.dynamic_input.oop;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

/**
 * @author bvanchuhov
 */
public class OOPDynamicInputSample {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        Reader consoleReader = new InputStreamReader(System.in);
        Iterator<Integer> intReader = new IntIterator(consoleReader, 0);
        while (intReader.hasNext()) {
            int elem = intReader.next();
            dynamicArray.add(elem);
        }

        System.out.println(dynamicArray);
    }
}
