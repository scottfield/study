package com.jackie.patterns.creational.abstract_factory;

/**
 * Created by jackie on 5/27/2016.
 */
public class OSThemeFacotry implements ThemeFactory {
    @Override
    public Button createButton() {
        return new OSButton();
    }

    @Override
    public Dialog createDialog() {
        return new OSDialog();
    }
}
