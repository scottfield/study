package com.jackie.patterns.structural.bridge;

/**
 * Created by jackie on 5/31/2016.
 */
public class Pentagon extends Shape {

    public Pentagon(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }
}
