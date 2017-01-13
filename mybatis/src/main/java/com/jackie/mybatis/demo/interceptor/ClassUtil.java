package com.jackie.mybatis.demo.interceptor;

import java.lang.reflect.Field;

/**
 * Created by jackie on 10/31/2016.
 */
public class ClassUtil {
    public static void setValue(Object target, String field, Object value) {
        Class clazz = target.getClass();
        try {
            Field sqlField = clazz.getDeclaredField(field);
            sqlField.setAccessible(true);
            sqlField.set(target, value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("cannot find filed declared in this class cause:", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("cannot access this filed cause:", e);
        }
    }

    public static Object newInstance(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Object o = clazz.newInstance();
            return o;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
