package com.jackie.io;

import java.io.IOException;

/**
 * Created by jackie on 8/2/2016.
 */
public class StreamPrinter {
    public static void main(String[] args) {
        while (true) {
            try {
                int data = System.in.read();
                if (data == -1) {
                    break;
                }
                System.out.println(data);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
