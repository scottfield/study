package com.jackie.patterns.creational.abstract_factory;

/**
 * Created by jackie on 5/27/2016.
 */
public class WinThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Dialog createDialog() {
        return new WinDialog();
    }
}
