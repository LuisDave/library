package com.onlinelibrary.management.exception;

import org.springframework.http.HttpStatus;

public abstract class GenericBookException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String code;
	private final String description;
	private final HttpStatus httpStatus;

	protected GenericBookException(ExceptionBookCode exBCode, HttpStatus httpStatus) {
		super();
		this.code = exBCode.getCode();
		this.description = exBCode.getDescription();
		this.httpStatus = httpStatus;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
