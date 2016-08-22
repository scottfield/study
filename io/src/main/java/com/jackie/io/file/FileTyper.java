package com.jackie.io.file;

import com.jackie.io.StreamCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jackie on 8/2/2016.
 */
public class FileTyper {
    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("user.dir"));//获取当前工作目录
//            InputStream in = FileTyper.class.getClassLoader().getResourceAsStream("readme.txt");
            InputStream in = new FileInputStream(new File("readme.txt"));//改文件需在当前工作目录下存在
            StreamCopier.copy(in, System.out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
