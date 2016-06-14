package com.jackie.se.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 6/1/2016.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("jackie");
        names.add("tom");
        names.add("scott");
        for (String name : names) {
            System.out.println(name);
            names.add("jersey");
        }
    }
}
