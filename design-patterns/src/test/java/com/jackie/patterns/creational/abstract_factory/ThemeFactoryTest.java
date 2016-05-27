package com.jackie.patterns.creational.abstract_factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jackie on 5/27/2016.
 */
public class ThemeFactoryTest {
    private ThemeFactory factory;

    @Before
    public void setup() {
        factory = ThemeFactoryCreator.getFactory("com.jackie.patterns.creational.abstract_factory.OSThemeFacotry");
//        factory = ThemeFactoryCreator.getFactory("com.jackie.patterns.creational.abstract_factory.WinThemeFactory");
    }

    @After
    public void teardown() {
        factory = null;
    }

    @Test
    public void createButton() throws Exception {
        factory.createButton();
    }

    @Test
    public void createDialog() throws Exception {
        factory.createDialog();
    }
}