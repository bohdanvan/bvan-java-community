package com.bvan.jc.oop.rectangle;

/**
 * @author bvanchuhov
 */
public class RectanglesRunner {

    public static void main(String[] args) {
        Rectangles rectangles = new Rectangles();
        rectangles.add(new Rectangle(10., 20.)); // 200
        rectangles.add(new Rectangle(5., 2.)); // 10

        System.out.println(rectangles.getArea()); // 210
        System.out.println(rectangles);
    }
}
