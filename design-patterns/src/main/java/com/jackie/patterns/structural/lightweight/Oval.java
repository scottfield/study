package com.jackie.patterns.structural.lightweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by jackie on 5/30/2016.
 */
public class Oval implements Shape {
    private boolean fill;

    public Oval(boolean fill) {
        this.fill=fill;
        System.out.println("Creating Oval object with fill="+fill);
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics oval, int x, int y, int width, int height, Color color) {
        oval.setColor(color);
        oval.drawOval(x, y, width, height);
        if(fill){
            oval.fillOval(x, y, width, height);
        }
    }
}
