package com.jackie.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * Created by jackie on 11/15/2016.
 */
public class FileAPIDemo {
    public static void main(String[] args) {
        System.out.println(4&1);
        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
    }
}
