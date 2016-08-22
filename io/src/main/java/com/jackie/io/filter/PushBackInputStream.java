package com.jackie.io.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * Created by jackie on 8/15/2016.
 */
public class PushBackInputStream {
    public static void main(String[] args) {
        byte[] dataum = "abcdef".getBytes();
        InputStream in = new ByteArrayInputStream(dataum);
        int c = -1;
        PushbackInputStream pbin = new PushbackInputStream(in);
        try {
            while (true) {
                c = pbin.read();
                if (c == -1) {
                    break;
                } else if (c == 'b') {
                    pbin.unread('B');
                } else {
                    System.out.write(c);
                }

            }
            System.out.flush();
        } catch (IOException e) {
            System.out.println("cannot read input stream");
        } finally {
            try {
                pbin.close();
            } catch (IOException e) {
                System.out.println("cannot close input stream");
            }
        }
    }
}
