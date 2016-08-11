package com.jackie.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jackie on 8/2/2016.
 */
public class StreamCopier {
    public static void main(String[] args) {
        try {
            copy(System.in,System.out);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void copy(InputStream in, OutputStream out) throws IOException {
        while (true) {
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            if (bytesRead == -1) {
                break;
            }
            out.write(buffer,0,bytesRead);
        }
    }
}
