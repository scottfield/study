package com.jackie.io;

import java.io.IOException;

/**
 * Created by jackie on 7/28/2016.
 * java中对数据的表示
 */
public class DataTypeDemo {
    public static void main(String[] args) throws IOException {
        int n=1;
        long l=1L;
        short s=1;
        byte b=1;
        b= (byte) 255;
        System.out.println(b);//-1
        b=-128;
        System.out.println(b);
        byte[] hello = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33, 10,
                13};
        System.out.write(hello);



    }
}
