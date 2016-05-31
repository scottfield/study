package com.jackie.patterns.structural.decorator;

/**
 * Created by jackie on 5/31/2016.
 */
public class LuxuryCarDecorator extends CarDecorator {
    public LuxuryCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}
