package com.jackie.patterns.structural.bridge;

/**
 * Created by jackie on 5/31/2016.
 */
public class Triangle extends Shape {
    public Triangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}
