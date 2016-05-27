package com.jackie.patterns.creational.abstract_factory;

/**
 * Created by jackie on 5/27/2016.
 * 抽象工厂模式
 */
public interface ThemeFactory {
    Button createButton();

    Dialog createDialog();
}
