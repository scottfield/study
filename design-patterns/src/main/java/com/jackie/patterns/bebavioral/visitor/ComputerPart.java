package com.jackie.patterns.bebavioral.visitor;

/**
 * Created by jackie on 6/23/2016.
 */
public interface ComputerPart {
    void accept(ComputerVisitor visitor);
}
