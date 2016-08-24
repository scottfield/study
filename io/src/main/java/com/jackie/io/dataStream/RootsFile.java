package com.jackie.io.dataStream;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jackie on 8/22/2016.
 */
public class RootsFile {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("d:\\roots.dat"));
            for (int i = 0; i < 1000; i++) {
                dos.writeDouble(Math.sqrt(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e
                ) {

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
