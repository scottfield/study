package com.jackie.patterns.bebavioral.command;

/**
 * Created by jackie on 6/16/2016.
 * request class
 */
public class Stock {
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("buy stock "+name+" of quantity "+quantity);
    }
    public void sell() {
        System.out.println("sell stock "+name+" of quantity "+quantity);
    }
}
