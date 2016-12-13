package com.bvan.jc.oop.dynamic_input.partial_oop;

import com.bvan.jc.oop.dynamic_input.oop.DynamicArray;
import java.util.Scanner;

/**
 * @author bvanchuhov
 */
public class PartialOOPDynamicInputSample {

    public static void main(String[] args) {
        DynamicArray elems = readClientElemsFromConsole();
        System.out.println("Your numbers: " + elems.toString());
    }

    private static DynamicArray readClientElemsFromConsole() {
        Scanner scanner = new Scanner(System.in);

        DynamicArray elems = new DynamicArray();

        int n = readInt(scanner);
        while (n != 0) {
            elems.add(n);
            n = readInt(scanner);
        }
        return elems;
    }

    private static int readInt(Scanner scanner) {
        System.out.print(">> ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Sorry, illegal input");
            System.out.print(">> ");
        }
        return scanner.nextInt();
    }
}
