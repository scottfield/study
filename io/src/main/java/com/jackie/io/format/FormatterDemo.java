package com.jackie.io.format;

import java.util.Formatter;

/**
 * Created by jackie on 8/17/2016.
 */
public class FormatterDemo {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("this is a %s world", "wonderful");
        String result = formatter.toString();
        formatter.flush();
        formatter.close();
        System.out.println(result);

    }
}

