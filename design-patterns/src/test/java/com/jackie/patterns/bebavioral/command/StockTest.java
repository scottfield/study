package com.jackie.patterns.bebavioral.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jackie on 6/16/2016.
 */
public class StockTest {
    private Broker broker;

    @Before
    public void setup() {
        broker = new Broker();
    }

    @After
    public void teardown() {
        broker = null;
    }

    @Test
    public void testBuy() throws Exception {
        Order abc = new BuyStock(new Stock("abc", 100));
        Order def = new BuyStock(new Stock("def", 100));
        broker.takeOrder(abc);
        broker.takeOrder(def);
        broker.placeOrders();
    }

    @Test
    public void testSell() throws Exception {
        Order abc = new SellStock(new Stock("abc", 100));
        Order def = new SellStock(new Stock("def", 100));
        broker.takeOrder(abc);
        broker.takeOrder(def);
        broker.placeOrders();
    }
}