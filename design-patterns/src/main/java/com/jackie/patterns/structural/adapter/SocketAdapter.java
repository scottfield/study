package com.jackie.patterns.structural.adapter;

/**
 * Created by jackie on 5/30/2016.
 */
public interface SocketAdapter {
    Volt get120Volt();

    Volt get12Volt();

    Volt get3Volt();
}
