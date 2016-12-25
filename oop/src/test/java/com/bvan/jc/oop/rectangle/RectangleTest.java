package com.bvan.jc.oop.rectangle;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author bvanchuhov
 */
public class RectangleTest {

    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(10., 20.);
        assertThat(rectangle.getPerimeter(), is(60.));
    }

    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle(10., 20.);
        assertThat(rectangle.getArea(), is(200.));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidth() {
        new Rectangle(-1., 10);
    }


}
