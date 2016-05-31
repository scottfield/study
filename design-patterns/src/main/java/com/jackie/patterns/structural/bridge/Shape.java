package com.jackie.patterns.structural.bridge;

/**
 * Created by jackie on 5/31/2016.
 */
public abstract class Shape {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    public Shape(Color c) {
        this.color = c;
    }

    public abstract void applyColor();
}
