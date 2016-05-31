package com.jackie.patterns.bebavioral.strategy;

/**
 * Created by jackie on 5/31/2016.
 */
public class Item {
    private String upcCode;
    private int price;

    public Item(String upcCode, int price) {
        this.price = price;
        this.upcCode = upcCode;
    }

    public int getPrice() {
        return price;
    }

    public String getUpcCode() {
        return upcCode;
    }
}
