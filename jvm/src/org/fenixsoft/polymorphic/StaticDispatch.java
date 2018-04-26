package org.fenixsoft.polymorphic;

/**
 * Created by jackie on 11/28/2016.
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("hello human");
    }

    public void sayHello(Man man) {
        System.out.println("hello man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello((Man) man);
        sd.sayHello((Woman) woman);
    }
}
