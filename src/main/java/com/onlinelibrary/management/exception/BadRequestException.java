package com.onlinelibrary.management.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends GenericBookException {

    private static final long serialVersionUID = 1L;

    public BadRequestException(ExceptionBookCode exBCode) {
        super(exBCode, HttpStatus.BAD_REQUEST);
    }

}
