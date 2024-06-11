package com.onlinelibrary.management.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlinelibrary.management.exception.BadRequestException;
import com.onlinelibrary.management.exception.ExceptionBookCode;
import com.onlinelibrary.management.exception.GenericBookException;
import com.onlinelibrary.management.repository.BookRepository;

@Component
public class IsbnValidator implements Validator<String>, ObjectValidator {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void validate(String object, Object... objectParam) throws GenericBookException {
		boolean exists = bookRepository.existsByIsbnAndActive(object, true);
		if (exists) {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_002);
		}
	}

}
