package com.jackie.patterns.bebavioral.chainofresponsibility;

/**
 * Created by jackie on 5/31/2016.
 */
public class Dollar50Dispenser implements DispenseChain {
    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 50) {
            int num = cur.getAmount() / 50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note");
            if (remainder != 0) this.nextChain.dispense(new Currency(remainder));
        } else {
            this.nextChain.dispense(cur);
        }
    }
}
