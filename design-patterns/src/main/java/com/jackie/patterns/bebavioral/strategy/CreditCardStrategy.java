package com.jackie.patterns.bebavioral.strategy;

/**
 * Created by jackie on 5/31/2016.
 */
public class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String cardNumber, String cvv, String dateOfExpiry, String name) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount +" paid with credit/debit card");
    }
}
