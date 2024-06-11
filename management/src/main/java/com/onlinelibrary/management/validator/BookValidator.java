package com.onlinelibrary.management.validator;

import org.springframework.stereotype.Component;

import com.onlinelibrary.management.dto.BookDTO;
import com.onlinelibrary.management.exception.BadRequestException;
import com.onlinelibrary.management.exception.ExceptionBookCode;
import com.onlinelibrary.management.exception.GenericBookException;

@Component
public class BookValidator implements Validator<BookDTO>, ObjectValidator {
	
	private static final String ISBN_REGEX = "\\d{13}";
    
	@Override
	public void validate(BookDTO bookDTO, Object... objectParam) throws GenericBookException {

		if (isNullOrEmpty(bookDTO.getTitle())) {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_003);
		}
		if (isNullOrEmpty(bookDTO.getAuthor())) {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_004);
		}
		if (isNullOrEmpty(bookDTO.getIsbn()) || !bookDTO.getIsbn().matches(ISBN_REGEX)) {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_005);
		}
		if (bookDTO.getPrice() == null || bookDTO.getPrice() <= 0) {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_006);
		}
		if (bookDTO.getType() == null || bookDTO.getType() < 1 || bookDTO.getType() > 6) {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_007);
		}        
	}
}
