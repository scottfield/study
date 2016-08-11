package com.jackie.io.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jackie on 2016/8/11.
 */
public class URLDemo {
    public static void main(String[] args) {
        InputStream in = null;

        try {
            URL url = new URL("http", "www.baidu.com", 80, "/");
            in = url.openStream();

            for (int c = in.read(); c != -1; c = in.read()) {
                System.out.write(c);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
