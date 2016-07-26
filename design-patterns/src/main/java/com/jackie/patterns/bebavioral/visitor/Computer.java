package com.jackie.patterns.bebavioral.visitor;

/**
 * Created by jackie on 6/23/2016.
 */
public class Computer implements ComputerPart {
    private ComputerPart[] parts = {new Mouse(), new Monitor(), new Keyboard()};

    @Override
    public void accept(ComputerVisitor visitor) {
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }
}
