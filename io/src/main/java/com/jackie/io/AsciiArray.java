package com.jackie.io;

import java.io.IOException;

/**
 * Created by jackie on 8/1/2016.
 */
public class AsciiArray {
    public static void main(String[] args) {
        byte[] b = new byte[(127 - 31) * 2];
        int index = 0;
        for (int i = 32; i < 127; i++) {
            b[index++] = (byte) i;
            if (i % 8 == 7) {
                b[index++] = '\n';
            } else {
                b[index++] = '\t';
            }
        }
        b[index++] = '\n';
        try {
            System.out.write(b);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
