package org.fenixsoft.polymorphic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jackie on 11/30/2016.
 */
public class GenericTypes {
    public static void method(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }

        int[] arr = {1, 2, 3};
        for (int i : arr) {
            System.out.println(i);
        }
        List<Integer> test = Arrays.asList(11, 11, 11);
        for (Integer integer : test) {
            System.out.println(integer);
        }

    }
}
