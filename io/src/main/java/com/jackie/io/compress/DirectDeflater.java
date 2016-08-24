package com.jackie.io.compress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

/**
 * Created by Jackie on 2016/8/24.
 */
public class DirectDeflater {
    public final static String DEFLATE_SUFFIX = ".dfl";
    private static String filename = "D:\\dev\\java\\io\\OReilly.Java.IO.pdf";

    public static void main(String[] args) throws IOException {
        Deflater def = new Deflater();
        byte[] input = new byte[1024];
        byte[] output = new byte[1024];
        for (int i = 0; i < args.length; i++) {
            FileInputStream fin = new FileInputStream(filename);
            FileOutputStream fout = new FileOutputStream(filename + DEFLATE_SUFFIX);
            while (true) { // read and deflate the data
                // Fill the input array.
                int numRead = fin.read(input);
                if (numRead == -1) { // end of stream
                    // Deflate any data that remains in the input buffer.
                    def.finish();
                    while (!def.finished()) {
                        int numCompressedBytes = def.deflate(output, 0, output.length);
                        if (numCompressedBytes > 0) {
                            fout.write(output, 0, numCompressedBytes);
                        } // end if
                    }  // end while
                    break; // Exit while loop.
                } // end if
                else {  // Deflate the input.
                    def.setInput(input, 0, numRead);
                    while (!def.needsInput()) {
                        int numCompressedBytes = def.deflate(output, 0, output.length);
                        if (numCompressedBytes > 0) {
                            fout.write(output, 0, numCompressedBytes);
                        } // end if
                    }  // end while
                }  // end else
            } // end while
            fin.close();
            fout.flush();
            fout.close();
            def.reset();
        }
    }

}
