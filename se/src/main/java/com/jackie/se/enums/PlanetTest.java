package com.jackie.se.enums;

public class PlanetTest {
    public static void main(String[] args) {
        double earthWeight = 12;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for(Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                p, p.surfaceWeight(mass));
    }
}
