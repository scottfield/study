package com.jackie.patterns.structural.lightweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by jackie on 5/30/2016.
 */
public class Line implements Shape {
    public Line() {
        System.out.println("Creating Line object");
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics line, int x, int y, int width, int height, Color color) {
        line.setColor(color);
        line.drawLine(x, y, width, height);
    }
}
