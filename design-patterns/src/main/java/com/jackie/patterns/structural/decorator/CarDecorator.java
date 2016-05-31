package com.jackie.patterns.structural.decorator;

/**
 * Created by jackie on 5/31/2016.
 */
public abstract class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}
