package com.jackie.patterns.structural.decorator;

/**
 * Created by jackie on 5/31/2016.
 */
public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}
