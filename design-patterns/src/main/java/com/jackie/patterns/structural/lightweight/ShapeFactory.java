package com.jackie.patterns.structural.lightweight;

import java.util.HashMap;

/**
 * Created by jackie on 5/30/2016.
 */
public class ShapeFactory {
    private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.get(type);

        if (shapeImpl == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shapeImpl = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOT_FILL)) {
                shapeImpl = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
                shapeImpl = new Line();
            }
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public enum ShapeType {
        OVAL_FILL, OVAL_NOT_FILL, LINE
    }
}
