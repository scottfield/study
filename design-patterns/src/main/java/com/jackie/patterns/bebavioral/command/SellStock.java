package com.jackie.patterns.bebavioral.command;

/**
 * Created by jackie on 6/16/2016.
 */
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
