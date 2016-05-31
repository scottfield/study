package com.jackie.patterns.bebavioral.template;

/**
 * Created by jackie on 5/31/2016.
 */
public class WoodenHouse extends HouseTemplate {
    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }
}
