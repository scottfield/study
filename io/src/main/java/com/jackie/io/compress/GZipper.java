package com.jackie.io.compress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Jackie on 2016/8/29.
 */
public class GZipper {
    public static final String GZIP_SUFFIX = ".gz";
    public static final String fileName = "D:\\avalon.pdf";

    public static void main(String[] args) {
        GZIPOutputStream gos = null;
        try {
            InputStream is = new FileInputStream(fileName);
            OutputStream os = new FileOutputStream(fileName + GZIP_SUFFIX);
            gos = new GZIPOutputStream(os);
            for (int c = is.read(); c == -1; c = is.read()) {
                gos.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                gos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
