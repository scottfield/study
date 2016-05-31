package com.jackie.patterns.structural.composite;

/**
 * Created by jackie on 5/30/2016.
 */
public class Circle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color "+fillColor);
    }
}
