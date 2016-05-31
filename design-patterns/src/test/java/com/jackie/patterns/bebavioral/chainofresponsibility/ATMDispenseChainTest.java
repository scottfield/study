package com.jackie.patterns.bebavioral.chainofresponsibility;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 5/31/2016.
 */
public class ATMDispenseChainTest {
    private ATMDispenseChain chain;

    @Before
    public void setUp() throws Exception {
        chain = new ATMDispenseChain();

    }

    @Test
    public void dispense() throws Exception {
        List<Integer> amounts = new ArrayList<>();
        amounts.add(10);
        amounts.add(100);
        amounts.add(50);
        amounts.add(120);
        amounts.add(9);
        for (Integer amount : amounts) {
            chain.dispense(amount);
        }
    }
}