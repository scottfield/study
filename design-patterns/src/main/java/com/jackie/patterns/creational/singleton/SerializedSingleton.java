package com.jackie.patterns.creational.singleton;

import java.io.Serializable;

/**
 * Created by jackie on 5/27/2016.
 */
public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -4066764432388703036L;

    private static class SingletonHelper {
        private static final SerializedSingleton SINGLETON = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.SINGLETON;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
