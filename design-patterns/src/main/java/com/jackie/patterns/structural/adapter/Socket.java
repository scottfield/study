package com.jackie.patterns.structural.adapter;

/**
 * Created by jackie on 5/30/2016.
 * adaptee(被适配对象)
 */
public class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}
