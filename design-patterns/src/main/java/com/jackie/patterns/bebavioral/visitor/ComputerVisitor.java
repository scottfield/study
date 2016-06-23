package com.jackie.patterns.bebavioral.visitor;

/**
 * Created by jackie on 6/23/2016.
 */
public interface ComputerVisitor {
    void visit(Monitor monitor);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Computer computer);
}
