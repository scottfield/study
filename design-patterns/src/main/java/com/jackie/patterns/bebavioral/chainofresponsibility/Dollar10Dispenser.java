package com.jackie.patterns.bebavioral.chainofresponsibility;

/**
 * Created by jackie on 5/31/2016.
 */
public class Dollar10Dispenser implements DispenseChain {
    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 10) {
            int num = cur.getAmount() / 10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing " + num + " 10$ note");
            if (remainder != 0) this.nextChain.dispense(new Currency(remainder));
        } else {
            this.nextChain.dispense(cur);
        }
    }
}
