package com.jackie.io;

import java.io.Console;

/**
 * Created by jackie on 8/1/2016.
 */
public class ConsoleClassDemo {
    public static void main(String[] args) {
        Console console = System.console();
        console.printf("please enter integer from 1 to 10");
        String number = console.readLine();
        Integer value = Integer.valueOf(number);
        for (int i = 0; i < value; i++) {
            System.out.println("the square of "+i+" = "+i*i);
        }
    }
}
