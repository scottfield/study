package com.jackie.io.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jackie on 8/11/2016.
 */
public class HelloServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9527);
            while (true) {
                Socket socket = ss.accept();
                OutputStream out = socket.getOutputStream();
                out.write("你好".getBytes());
                out.flush();
                out.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
