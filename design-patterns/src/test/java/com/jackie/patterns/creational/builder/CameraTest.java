package com.jackie.patterns.creational.builder;

import org.junit.Test;

/**
 * Created by jackie on 5/27/2016.
 */
public class CameraTest {
    @Test
    public void testBuildCamera() {
        Camera camera = new Camera.CameraBuilder("2G", "8G").setBluetoothEnabled(false).setGraphicsCardEnabled(false).build();
        System.out.println(camera);
    }

}