package com.jackie.patterns.creational.singleton;

/**
 * Created by jackie on 5/27/2016.
 */
public class BillPughSingleton {
    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton BILL_PUGH_SINGLETON = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.BILL_PUGH_SINGLETON;
    }
}
