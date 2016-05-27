package com.jackie.patterns.creational.singleton;

/**
 * Created by jackie on 5/27/2016.
 */
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }
}
