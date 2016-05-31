package com.jackie.patterns.bebavioral.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 5/31/2016.
 */
public class ShoppingCart {
    //List of items
    List<Item> items;
    public ShoppingCart(){
        this.items= new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal(){
        int sum = 0;
        for(Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}
