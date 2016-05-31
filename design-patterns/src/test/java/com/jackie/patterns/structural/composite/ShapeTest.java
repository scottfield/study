package com.jackie.patterns.structural.composite;

import org.junit.Test;

/**
 * Created by jackie on 5/30/2016.
 */
public class ShapeTest {

    @Test
    public void testDraw() throws Exception {
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");

        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}