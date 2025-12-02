package com.kondratiev.st.exception;

public class TextOperatingException extends Exception {

    public TextOperatingException() {
        super();
    }

    public TextOperatingException(String message) {
        super(message);
    }

    public TextOperatingException(Throwable reason) {
        super(reason);
    }

    public TextOperatingException(String message, Throwable reason) {
        super(message, reason);
    }
}
