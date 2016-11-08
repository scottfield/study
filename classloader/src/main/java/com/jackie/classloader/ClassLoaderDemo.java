package com.jackie.classloader;

/**
 * Created by jackie on 11/8/2016.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("class loader for HashMap: "
                + java.util.HashMap.class.getClassLoader());
        System.out.println("class loader for DNSNameService: "
                + sun.net.spi.nameservice.dns.DNSNameService.class
                .getClassLoader());
        System.out.println("class loader for this class: "
                + ClassLoaderDemo.class.getClassLoader());
    }
}
