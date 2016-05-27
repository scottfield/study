package com.jackie.patterns.creational.singleton;

/**
 * Created by jackie on 5/27/2016.
 */
public class StaticBlockSingleton {
    private static final StaticBlockSingleton BLOCK_SINGLETON;

    static {
        try {
            BLOCK_SINGLETON = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    private StaticBlockSingleton() {
    }

    public static final StaticBlockSingleton getInstance() {
        return BLOCK_SINGLETON;
    }
}
