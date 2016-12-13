package com.bvan.jc.oop.dynamic_input.procedural;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author bvanchuhov
 */
public class DynamicInputSampleWithSimpleAlg {

    public static void main(String[] args) {
        int[] array = readClientElemsFromConsole();
        System.out.println("Your numbers: " + Arrays.toString(array));
    }

    private static int[] readClientElemsFromConsole() {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[0];

        int n = readInt(scanner);
        while (n != 0) {
            array = addLast(array, n);
            n = readInt(scanner);
        }
        return array;
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

    public static int[] addLast(int[] array, int n) {
        int[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = n;
        return newArray;
    }
}

// []
// [10]
// [10, 20]
