package com.bvan.jc.oop.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author bvanchuhov
 */
public class Shapes implements Iterable<Shape> {

    private final List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public double getArea() {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.getArea();
        }
        return area;
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Shape shape : shapes) {
            stringJoiner.add(shape.toString());
        }
        return "Shapes:\n" + stringJoiner.toString();
    }
}
