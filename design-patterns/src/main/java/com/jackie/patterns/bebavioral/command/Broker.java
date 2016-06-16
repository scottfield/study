package com.jackie.patterns.bebavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 6/16/2016.
 */
public class Broker {
    private List<Order> orders;

    public Broker() {
        orders = new ArrayList<>();
    }

    public void takeOrder(Order order) {
        orders.add(order);
    }

    public void placeOrders() {
        orders.stream().forEach(Order::execute);
    }
}
