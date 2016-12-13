package com.bvan.jc.oop.dynamic_input.procedural;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author bvanchuhov
 */
public class DynamicInputSample {

    public static void main(String[] args) {
        int[] array = readClientElemsFromConsole();
        System.out.println("Your numbers: " + Arrays.toString(array));
    }

    private static int[] readClientElemsFromConsole() {
        Scanner scanner = new Scanner(System.in);

        int size = 0;
        int[] array = new int[10];

        int n = readInt(scanner); // Client
        while (n != 0) {
            if (array.length == size) {
                array = grow(array);
            }
            array[size++] = n;

            n = readInt(scanner); // Client
        }
        return Arrays.copyOf(array, size);
    }

    private static int[] grow(int[] array) {
        return Arrays.copyOf(array, array.length * 2);
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

// >> 10
// >> 20
// >> 0
// 10, 20

// [10, 20, 30, ..., 10], size = 10
// [10, 20, 30, ..., 100, _, _, _, ...., _]
