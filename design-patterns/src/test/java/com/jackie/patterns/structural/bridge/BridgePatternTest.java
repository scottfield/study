package com.jackie.patterns.structural.bridge;

import org.junit.Test;

/**
 * Created by jackie on 5/31/2016.
 */
public class BridgePatternTest {
    @Test
    public void testBridgePattern() throws Exception {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}