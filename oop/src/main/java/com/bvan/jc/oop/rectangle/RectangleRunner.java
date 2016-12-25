package com.bvan.jc.oop.rectangle;

/**
 * @author bvanchuhov
 */
public class RectangleRunner {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10.0, 20.0);
        System.out.println(rectangle.getPerimeter()); // 60
        System.out.println(rectangle.getArea()); // 200
        System.out.println(rectangle);
    }
}
