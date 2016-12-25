package com.bvan.jc.oop.shapes;

/**
 * @author bvanchuhov
 */
public class ShapesFactory {

    public static Shape circle(double radius) {
        return new Circle(radius);
    }

    public static Shape rectangle(double width, double height) {
        return new Rectangle(width, height);
    }

    public static Shape square(double side) {
        return new Rectangle(side, side);
    }
}
