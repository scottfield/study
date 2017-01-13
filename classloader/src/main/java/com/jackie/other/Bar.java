package com.jackie.other;

import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by jackie on 11/8/2016.
 */
public class Bar {
    public Bar(String a, String b) {
        System.out.println("Bar Constructor >>> " + a + " " + b);
        FTPClient client = new FTPClient();
        System.out.println(client);
    }

    public void printCL() {
        System.out.println("Bar ClassLoader: "+Bar.class.getClassLoader());
    }
}
