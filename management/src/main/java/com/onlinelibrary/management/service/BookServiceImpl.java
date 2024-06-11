package com.onlinelibrary.management.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinelibrary.management.dto.BookDTO;
import com.onlinelibrary.management.exception.BadRequestException;
import com.onlinelibrary.management.exception.ExceptionBookCode;
import com.onlinelibrary.management.model.Book;
import com.onlinelibrary.management.repository.BookRepository;
import com.onlinelibrary.management.validator.ObjectValidator;
import com.onlinelibrary.management.validator.Validator;

/**
 * Implementation of the BookService interface.
 */
@Service
public class BookServiceImpl implements BookService, ObjectValidator {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private Validator<BookDTO> bookValidator;
	@Autowired
	private Validator<String> isbnValidator;

	@Override
	public Book createBook(BookDTO bookDTO) {
		bookValidator.validate(bookDTO);
		isbnValidator.validate(bookDTO.getIsbn());

		Book book = new Book();
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublisher(bookDTO.getPublisher());
		book.setPublicationDate(bookDTO.getPublicationDate());
		book.setPrice(bookDTO.getPrice());
		book.setActive(true);
		book.setCreationTime(LocalDateTime.now());
		book.setType(bookDTO.getType());
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}

	@Override
	public Book getBookById(Long id) {
		Book book = bookRepository.findByIdAndActive(id,true);
		if (book != null) {
			return book;
		} else {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_008);
		}
	}

	@Override
	public Book updateBook(Long id, BookDTO bookDTO) {
		Book book = bookRepository.findByIdAndActive(id, true);
		bookValidator.validate(bookDTO);
		if (book != null) {
			book.setTitle(getValidString(bookDTO.getTitle(), book.getTitle()));
			book.setAuthor(getValidString(bookDTO.getAuthor(), book.getAuthor()));

			if (!bookDTO.getIsbn().equals(book.getIsbn())) {
				isbnValidator.validate(bookDTO.getIsbn());
			}
			book.setIsbn(getValidString(bookDTO.getIsbn(), book.getIsbn()));
			book.setPublisher(getValidString(bookDTO.getPublisher(), book.getPublisher()));
			book.setPublicationDate(
					bookDTO.getPublicationDate() != null ? bookDTO.getPublicationDate() : book.getPublicationDate());
			book.setPrice(getValidDouble(bookDTO.getPrice(), book.getPrice()));
			book.setType(getValidInteger(bookDTO.getType(), book.getType()));
			book.setUpdateTime(LocalDateTime.now());
			return bookRepository.save(book);
		} else {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_008);
		}
	}

	@Override
	public void deleteBook(Long id) {
		Book book = bookRepository.findByIdAndActive(id, true);
		if (book != null) {
			book.setActive(false);
			book.setUpdateTime(LocalDateTime.now());
			bookRepository.save(book);
		} else {
			throw new BadRequestException(ExceptionBookCode.BOOK_ERR_008);
		}
	}

}
