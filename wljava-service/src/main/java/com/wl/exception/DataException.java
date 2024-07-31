package com.wl.exception;

import java.io.IOException;

public class DataException extends WLException {
    public DataException(String message) {
        super(message);
    }

    public DataException(String message, IOException e) {
        super(message, e);
    }
}
