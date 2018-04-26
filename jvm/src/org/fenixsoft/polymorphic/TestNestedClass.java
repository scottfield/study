package org.fenixsoft.polymorphic;

/**
 * Created by jackie on 11/30/2016.
 */
public class TestNestedClass {
    public final void outermethod() {
        System.out.println("outermethod");
    }

    public static void outeStaticrmethod() {
        System.out.println("outeStaticrmethod");
    }

    class NestClass {
        public void method() {
            outermethod();
            System.out.println("NestClass method");
        }
    }

    static class StaticNestClass {
        public void method() {
            outeStaticrmethod();
            System.out.println("StaticNestClass method");
        }
    }

    public static void main(String[] args) {
        new StaticNestClass().method();
        new TestNestedClass().new NestClass().method();
        String test = "fadfdafda";
        switch (test) {
            case "dddd":
                System.out.println("dddd");
                break;
            case "eeeee":
                System.out.println("eeee");
                break;
        }
        TEST x = TEST.D;
        switch (x) {
            case D:
                System.out.println("dskfd");
                break;
            case H:
                System.out.println("dskfd");
                break;
            case E:
                System.out.println("dskfd");
                break;
        }
    }

    enum TEST {
        H, D, E
    }
}
