package com.bvan.jc.oop.shapes;

/**
 * @author bvanchuhov
 */
public class Square implements Shape {

    private final Rectangle rectangle;

    public Square(double side) {
        rectangle = new Rectangle(side, side);
    }

    @Override
    public double getPerimeter() {
        return rectangle.getPerimeter();
    }

    @Override
    public double getArea() {
        return rectangle.getArea();
    }

    @Override
    public String toString() {
        return "Square{}";
    }
}
