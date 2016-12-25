package com.bvan.jc.oop.shapes;

import static com.bvan.jc.oop.shapes.ShapesFactory.circle;
import static com.bvan.jc.oop.shapes.ShapesFactory.rectangle;
import static com.bvan.jc.oop.shapes.ShapesFactory.square;

/**
 * @author bvanchuhov
 */
public class ShapesRunner {

    public static void main(String[] args) {
        Shapes shapes = new Shapes();
        shapes.add(rectangle(10., 20.)); // 200
        shapes.add(circle(10.)); // 314
        shapes.add(square(10.)); // 10

        System.out.println(shapes.getArea());
    }
}
