package org.fenixsoft.polymorphic;

/**
 * Created by jackie on 11/30/2016.
 */
public class TestConditionalCompile {
    public static void main(String[] args) {
        if (true) {
            System.out.println("conditional compile");
        } else {
            System.out.println("cannot see it");
        }
    }
}
