package com.building.common.exception;

import java.nio.file.AccessDeniedException;

public class MyaccessDeniedException extends AccessDeniedException {

    public MyaccessDeniedException(String msg) {
        super(msg);
    }

}
