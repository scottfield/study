package com.jackie.patterns.creational.factory;

import org.junit.Test;

/**
 * Created by jackie on 5/27/2016.
 */
public class ComputerFactoryTest {

    @Test
    public void getComputer() throws Exception {
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC Config::" + pc);
        System.out.println("Factory Server Config::" + server);
    }
}