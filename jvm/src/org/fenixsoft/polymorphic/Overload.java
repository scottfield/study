package org.fenixsoft.polymorphic;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by jackie on 11/28/2016.
 */
public class Overload {
    public static void hello(Object arg) {
        System.out.println("hello object");
    }

   /* public static void hello(int arg) {
        System.out.println("hello int");
    }*/

   /* public static void hello(long arg) {
        System.out.println("hello long");
    }*/
   public static void hello(float arg) {
       System.out.println("hello float");
   }
    public static void hello(double arg) {
        System.out.println("hello double");
    }

    /*public static void hello(Character arg) {
        System.out.println("hello Character");
    }*/

   /* public static void hello(char arg) {
        System.out.println("hello char");
    }*/

    public static void hello(char... arg) {
        System.out.println("hello char ...");
    }

    /*public static void hello(Serializable arg) {
        System.out.println("hello Serializable");
    }*/
    /*public static void hello(Comparable arg) {
        System.out.println("hello Comparable");
    }*/

    public static void main(String[] args) {
        hello('a');
    }
}
