package com.jackie.patterns.bebavioral.chainofresponsibility;

/**
 * Created by jackie on 5/31/2016.
 */
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
