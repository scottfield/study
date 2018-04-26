package com.jackie.mybatis.pagination.interceptor;

import java.lang.reflect.Field;

/**
 * Created by jackie on 10/31/2016.
 */
class ClassUtil {
    static void setValue(Object target, String field, Object value) {
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

    static Object newInstance(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
