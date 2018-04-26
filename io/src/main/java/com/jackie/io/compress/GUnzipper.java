package com.jackie.io.compress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/**
 * Created by Jackie on 2016/8/29.
 */
public class GUnzipper {
    public static final String fileName = "D:\\avalon.gz";

    public static void main(String[] args) {
        GZIPInputStream gis = null;
        try {
            InputStream is = new FileInputStream(fileName);
            gis = new GZIPInputStream(is);
            for (int c = gis.read(); c == -1; c = gis.read()) {
                System.out.write(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                gis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
