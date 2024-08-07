package com.wl.exception;

public abstract class WLException extends RuntimeException {

    private static final long serialVersionUID = 4284836223881670234L;

    public WLException(String message) {
        super(message);
    }

    public WLException(String message, Throwable cause) {
        super(message, cause);
    }
}
