package com.levelvini.test_dev.exceptions;

public class EmptyDataException extends RuntimeException{
    public EmptyDataException(String message) {
        super(message);
    }
}
