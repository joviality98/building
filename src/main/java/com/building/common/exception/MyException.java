package com.building.common.exception;

public class MyException extends RuntimeException {

    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}
