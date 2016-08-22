package com.jackie.io.dataStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jackie on 8/22/2016.
 */
public class File1000 {
    public static void main(String[] args) {
        DataOutputStream ops = null;
        try {
            ops = new DataOutputStream(new FileOutputStream("d:\\1000.bat"));
            for (int i = 0; i < 1000; i++) {
                ops.writeInt(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ops != null) {
                try {
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
