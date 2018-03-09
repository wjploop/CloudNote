package com.loop.service.impl;

/**
 * author  loop
 * create  2018-01-22 21:17.
 */


public class NameException extends RuntimeException {
    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }

    public NameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameException(Throwable cause) {
        super(cause);
    }

    public NameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
