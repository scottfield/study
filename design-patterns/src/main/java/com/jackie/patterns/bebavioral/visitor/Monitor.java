package com.jackie.patterns.bebavioral.visitor;

/**
 * Created by jackie on 6/23/2016.
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}
