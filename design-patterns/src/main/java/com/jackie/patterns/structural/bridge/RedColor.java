package com.jackie.patterns.structural.bridge;

/**
 * Created by jackie on 5/31/2016.
 */
public class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("red.");
    }
}
