package com.wl.exception;

public class WLIoException extends WLException {
    public WLIoException(String message) {
        super(message);
    }

    public WLIoException(String message, Exception e) {
        super(message, e);
    }
}
