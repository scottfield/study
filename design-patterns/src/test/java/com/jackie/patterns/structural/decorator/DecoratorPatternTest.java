package com.jackie.patterns.structural.decorator;

import org.junit.Test;

/**
 * Created by jackie on 5/31/2016.
 */
public class DecoratorPatternTest {
    @Test
    public void testDecoratorPattern() throws Exception {
        Car sportsCar = new SportsCarDecorator(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n***********************************");

        Car sportsLuxuryCar = new SportsCarDecorator(new LuxuryCarDecorator(new BasicCar()));
        sportsLuxuryCar.assemble();

    }
}