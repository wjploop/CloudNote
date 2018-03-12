package com.loop.service.exception;

public class NotebookException extends RuntimeException {

    public NotebookException() {
    }

    public NotebookException(String message) {
        super(message);
    }

    public NotebookException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotebookException(Throwable cause) {
        super(cause);
    }

    public NotebookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
