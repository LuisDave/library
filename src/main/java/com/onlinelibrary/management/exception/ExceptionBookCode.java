package com.onlinelibrary.management.exception;

public enum ExceptionBookCode {

	BOOK_ERR_001("BOOK_ERR_001", "An error occurred"), 
	BOOK_ERR_002("BOOK_ERR_002", "The book already exists"),
	BOOK_ERR_003("BOOK_ERR_003", "Title is required"), 
	BOOK_ERR_004("BOOK_ERR_004", "Author is required"),
	BOOK_ERR_005("BOOK_ERR_005", "ISBN must be a 13-digit number"),
	BOOK_ERR_006("BOOK_ERR_006", "Price must be greater than 0"),
	BOOK_ERR_007("BOOK_ERR_007", "Type must be between 1 and 6"),
	BOOK_ERR_008("BOOK_ERR_008", "The Book does not exist"),
	;

	private final String code;
	private final String description;

	ExceptionBookCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
