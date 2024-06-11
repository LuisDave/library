package com.onlinelibrary.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onlinelibrary.management.dto.GeneralError;
import com.onlinelibrary.management.exception.ExceptionBookCode;
import com.onlinelibrary.management.exception.GenericBookException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

	@ExceptionHandler(value = GenericBookException.class)
	public ResponseEntity<GeneralError> handleGenericException(GenericBookException ex, HttpServletRequest request) {
		logger.error("Error Code: {}, Description: {}, Path: {}", ex.getCode(), ex.getDescription(),
				request.getRequestURI(), ex);
		return new ResponseEntity<>(new GeneralError(ex.getCode(), ex.getDescription()), ex.getHttpStatus());
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<GeneralError> handleServerException(Exception ex, HttpServletRequest request) {
		logger.error("An unexpected error occurred at path: {}", request.getRequestURI(), ex);
		return new ResponseEntity<>(new GeneralError(ExceptionBookCode.BOOK_ERR_001, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}