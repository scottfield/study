package com.jackie.io.filter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jackie on 8/15/2016.
 */
public class PrintableInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected PrintableInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int b = in.read();
        // printing, ASCII characters
        if (b >= 32 && b <= 126) return b;
        else if (b == '\n' || b == '\r' || b == '\t') return b;
            // nonprinting characters
        else return '?';

    }

    public int read(byte[] data, int offset, int length) throws IOException {
        int result = in.read(data, offset, length);
        for (int i = offset; i < offset + result; i++) {
            // Do nothing with the printing characters.
            if (data[i] == '\n' || data[i] == '\r' || data[i] == '\t' || data[i] == -1) ;
                // nonprinting characters
            else if (data[i] < 32 || data[i] > 126) data[i] = (byte) '?';
        }
        return result;
    }

}
