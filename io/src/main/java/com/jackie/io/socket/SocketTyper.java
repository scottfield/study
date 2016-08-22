package com.jackie.io.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by jackie on 8/11/2016.
 */
public class SocketTyper {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            String file = "/tiandiqing/article/details/6536384";
            String host = "127.0.0.1";
            socket = new Socket(host, 9527);
            String request = "GET " + file + " HTTP/1.1\r\n"
                    + "User-Agent: SocketTyper\r\n"
                    + "Accept: text/*\r\n"
                    + "Host: " + host + "\r\n"
                    + "\r\n";
            byte[] bytes = request.getBytes("utf-8");
            OutputStream out = socket.getOutputStream();
            out.write(bytes);
            out.flush();
            InputStream in = socket.getInputStream();

            for (int c = in.read(); c != -1; c = in.read()) {
                System.out.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && socket.isConnected()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
