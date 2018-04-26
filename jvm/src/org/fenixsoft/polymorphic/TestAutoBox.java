package org.fenixsoft.polymorphic;

/**
 * Created by jackie on 11/30/2016.
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Integer h=642;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(h==e+f);
        System.out.println(h.equals(e+f));
        System.out.println(c == a + b);
        System.out.println(c.equals(a + b));
        System.out.println(g == a + b);
        System.out.println(g.equals(a + b));

    }
}
