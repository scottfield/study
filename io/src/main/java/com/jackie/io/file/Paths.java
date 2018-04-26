package com.jackie.io.file;

import java.io.File;
import java.io.IOException;

/**
 * Created by jackie on 11/15/2016.
 */
public class Paths {
    public static void main(String[] args) throws IOException {
        File absolute = new File("/public/html/javafaq/index.html");
        File relative = new File("html/javafaq/index.html");
        System.out.println("absolute: ");
        System.out.println(absolute.getName( ));
        System.out.println(absolute.getPath( ));
        System.out.println(absolute.exists());
        System.out.println(absolute.isFile());
        System.out.println(absolute.getAbsolutePath());
        System.out.println(absolute.isAbsolute());

        System.out.println("relative: ");
        System.out.println(relative.getName( ));
        System.out.println(relative.getPath( ));
        System.out.println(relative.exists());
        System.out.println(relative.isFile());
        System.out.println(relative.getAbsolutePath());
        System.out.println(relative.isAbsolute());

        File dir = new File("D:\\dev\\java\\io\\test.txt");
        System.out.println("dir:");
        System.out.println(dir.getName());
        System.out.println(dir.getPath());
        System.out.println(dir.exists());
        System.out.println(dir.isDirectory());
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.isAbsolute());
        System.out.println(dir.getCanonicalPath());
        System.out.println("-----");
        System.out.println(dir.canRead());
        System.out.println(dir.canWrite());
        System.out.println(dir.canExecute());
        System.out.println("is hidden:"+dir.isHidden());
        System.out.println("length:"+dir.length());
        System.out.println("last modified:"+dir.lastModified());

    }
}
