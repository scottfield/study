package com.jackie.patterns.bebavioral.visitor;

/**
 * Created by jackie on 6/23/2016.
 */
public class ComputerDisplayVIsitor implements ComputerVisitor {
    @Override
    public void visit(Monitor monitor) {
        System.out.println("display monitor");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("display mouse");

    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("display keyboard");

    }

    @Override
    public void visit(Computer computer) {
        System.out.println("display computer");

    }
}
