package com.kondratiev.st.reader;

import com.kondratiev.st.exception.TextOperatingException;

public interface TextReader {
    String readFile(String path) throws TextOperatingException;
}
