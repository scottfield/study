package com.jackie.patterns.bebavioral.visitor;

/**
 * Created by jackie on 6/23/2016.
 */
public class ComputerVisitDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerDisplayVIsitor());
    }
}
