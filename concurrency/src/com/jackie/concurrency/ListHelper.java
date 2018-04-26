package com.jackie.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jackie on 1/11/2017.
 */
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        System.out.println(absent);
        if (absent) {
            list.add(x);
        }
        return absent;
    }

    public List getList() {
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        final ListHelper<Integer> helper = new ListHelper<Integer>();
        for(int i=0;i<1000;i++) {
           Thread t = new Thread(){
               @Override
               public void run() {
                   helper.putIfAbsent(1);
               }
           };
           t.start();
        }
        Thread.sleep(3000);
        System.out.println(helper.getList().size());
    }
}
