package com.jackie.io.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jackie on 8/11/2016.
 */
public class MailClient {
    public static void main(String[] args) {
        OutputStream out = null;
        try {
            URL url = new URL("127.0.0.1");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.connect();
            out = connection.getOutputStream();
            out.write("hello world".getBytes());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
