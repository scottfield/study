package com.jackie.io.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jackie on 8/15/2016.
 */
public class StringExtractor {
    private static String fileName = "C:\\dev\\workspace\\study\\io\\target\\classes\\com\\jackie\\io\\filter\\StringExtractor.class";

    public static void main(String[] args) {
        InputStream in = null;
        PrintableOutputStream printableOutputStream = null;
        try {
            in = new FileInputStream(fileName);
            OutputStream out = System.out;
            printableOutputStream = new PrintableOutputStream(out);
            for (int c = in.read(); c != -1; c = in.read()) {
                printableOutputStream.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("cannot find file :" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (printableOutputStream != null) {
                    printableOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("cannot close input stream");
            }

        }

    }
}
