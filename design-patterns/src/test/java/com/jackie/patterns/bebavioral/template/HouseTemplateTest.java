package com.jackie.patterns.bebavioral.template;

import org.junit.Test;

/**
 * Created by jackie on 5/31/2016.
 */
public class HouseTemplateTest {

    @Test
    public void testBuildHouse() throws Exception {
        HouseTemplate houseType = new WoodenHouse();

        //using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();

        houseType.buildHouse();
    }
}