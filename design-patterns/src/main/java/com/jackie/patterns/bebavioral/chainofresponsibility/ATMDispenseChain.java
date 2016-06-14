package com.jackie.patterns.bebavioral.chainofresponsibility;

/**
 * Created by jackie on 5/31/2016.
 */
public class ATMDispenseChain {
    private DispenseChain dispenseChain;

    public ATMDispenseChain() {
        //initialize the request handler chain
        dispenseChain = new Dollar50Dispenser();
        DispenseChain dispenseChain20 = new Dollar20Dispenser();
        DispenseChain dispenseChain10 = new Dollar10Dispenser();
        dispenseChain.setNextChain(dispenseChain20);
        dispenseChain20.setNextChain(dispenseChain10);
    }

    public void dispense(int amount) {
        if (amount % 10 != 0) {
            System.out.println("Amount should be in multiple of 10s.");
            return;
        }
        // process the request
        dispenseChain.dispense(new Currency(amount));
    }
}
