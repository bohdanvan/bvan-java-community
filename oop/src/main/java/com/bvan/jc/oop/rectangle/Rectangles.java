package com.bvan.jc.oop.rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author bvanchuhov
 */
public class Rectangles implements Iterable<Rectangle> {

    private final List<Rectangle> rectangles = new ArrayList<>();

    public void add(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public double getArea() {
        double area = 0;
        for (Rectangle rectangle : rectangles) {
            area += rectangle.getArea();
        }
        return area;
    }

    @Override
    public Iterator<Rectangle> iterator() {
        return rectangles.iterator();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Rectangle rectangle : rectangles) {
            stringJoiner.add(rectangle.toString());
        }
        return "Rectangles:\n" + stringJoiner.toString();
    }
}
