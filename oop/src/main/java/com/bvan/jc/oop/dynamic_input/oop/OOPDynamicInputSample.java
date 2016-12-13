package com.bvan.jc.oop.dynamic_input.oop;

import com.bvan.jc.oop.dynamic_input.oop.iterator.ReaderIterator;
import com.bvan.jc.oop.dynamic_input.oop.iterator.TerminationIterator;
import com.bvan.jc.oop.dynamic_input.oop.iterator.UncorruptedIntTransformIterator;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

/**
 * @author bvanchuhov
 */
public class OOPDynamicInputSample {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        Iterator<Integer> intReader = createConsoleIntIterator();
        while (intReader.hasNext()) {
            int elem = intReader.next();
            dynamicArray.add(elem);
        }

        System.out.println(dynamicArray);
    }

    private static Iterator<Integer> createConsoleIntIterator() {
        Reader consoleReader = new InputStreamReader(System.in);
        int terminator = 0;
        return new TerminationIterator<Integer>(
                new UncorruptedIntTransformIterator(
                        new ReaderIterator(consoleReader)
                ),
                terminator
        );
    }
}
