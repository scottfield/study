package com.jackie.patterns.structural.lightweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by jackie on 5/30/2016.
 */
public interface Shape {
    void draw(Graphics g, int x, int y, int width, int height, Color color);
}
