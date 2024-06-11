package com.onlinelibrary.management.testdata;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.onlinelibrary.management.dto.BookDTO;
import com.onlinelibrary.management.model.Book;

/**
 * Utility class for generating test data for Book and BookDTO objects.
 */
public class BookTestData {

    public static final Long BOOK_ID = 1L;
    public static final String BOOK_TITLE = "Test Title";
    public static final String BOOK_AUTHOR = "Test Author";
    public static final String BOOK_ISBN = "1234567890123";
    public static final String BOOK_PUBLISHER = "Test Publisher";
    public static final LocalDate BOOK_PUBLICATION_DATE = LocalDate.of(2020, 1, 1);
    public static final Double BOOK_PRICE = 29.99;
    public static final Integer BOOK_TYPE = 1;
    public static final LocalDateTime BOOK_CREATION_TIME = LocalDateTime.now();

    /**
     * Generates a sample BookDTO object for testing.
     *
     * @return a sample BookDTO object
     */
    public static BookDTO getSampleBookDTO() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(BOOK_TITLE);
        bookDTO.setAuthor(BOOK_AUTHOR);
        bookDTO.setIsbn(BOOK_ISBN);
        bookDTO.setPublisher(BOOK_PUBLISHER);
        bookDTO.setPublicationDate(BOOK_PUBLICATION_DATE);
        bookDTO.setPrice(BOOK_PRICE);
        bookDTO.setType(BOOK_TYPE);
        return bookDTO;
    }

    /**
     * Generates a sample Book object for testing.
     *
     * @return a sample Book object
     */
    public static Book getSampleBook() {
        Book book = new Book();
        book.setId(BOOK_ID);
        book.setTitle(BOOK_TITLE);
        book.setAuthor(BOOK_AUTHOR);
        book.setIsbn(BOOK_ISBN);
        book.setPublisher(BOOK_PUBLISHER);
        book.setPublicationDate(BOOK_PUBLICATION_DATE);
        book.setPrice(BOOK_PRICE);
        book.setActive(true);
        book.setCreationTime(BOOK_CREATION_TIME);
        book.setType(BOOK_TYPE);
        return book;
    }
}
