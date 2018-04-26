package com.jackie.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

/**
 * Created by jackie on 11/17/2016.
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("D:/test.txt", "rw");
            file.write("hello world".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!Objects.isNull(null)) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
