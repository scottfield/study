package com.jackie.patterns.creational.singleton;

/**
 * Created by jackie on 5/27/2016.
 */
public enum EnumSingleton {
    INSTANCE;

    public static void doSomeWork() {
        System.out.println("do some work here.");
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomeWork();
    }

}
