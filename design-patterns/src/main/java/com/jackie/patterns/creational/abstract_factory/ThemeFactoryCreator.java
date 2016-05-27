package com.jackie.patterns.creational.abstract_factory;

/**
 * Created by jackie on 5/27/2016.
 */
public class ThemeFactoryCreator {
    public static ThemeFactory getFactory(String theme) {
        try {
            Class<?> clazz = Class.forName(theme);
            return (ThemeFactory) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("指定主题不存在", e);
        } catch (InstantiationException e) {
            throw new RuntimeException("创建主题失败", e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
