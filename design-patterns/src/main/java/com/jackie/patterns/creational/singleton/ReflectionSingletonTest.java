package com.jackie.patterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jackie on 5/27/2016.
 */
public class ReflectionSingletonTest {
    public static void main(String[] args) {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        SerializedSingleton instanceTwo = null;
        Constructor[] constructors = SerializedSingleton.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            try {
                instanceTwo = (SerializedSingleton) constructor.newInstance();
                break;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
