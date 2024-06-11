package com.onlinelibrary.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinelibrary.management.dto.BookDTO;
import com.onlinelibrary.management.exception.BadRequestException;
import com.onlinelibrary.management.model.Book;
import com.onlinelibrary.management.repository.BookRepository;
import com.onlinelibrary.management.testdata.BookTestData;
import com.onlinelibrary.management.validator.Validator;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    private static final Long BOOK_ID = BookTestData.BOOK_ID;
    private static final String BOOK_TITLE = BookTestData.BOOK_TITLE;
    private static final String UPDATED_TITLE = "Updated Title";
    private static final String UPDATED_ISBN = "9876543210123";
    private static final String UPDATED_PUBLISHER = "Updated Publisher";
    private static final Double UPDATED_PRICE = 39.99;

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private Validator<BookDTO> bookValidator;

    @Mock
    private Validator<String> isbnValidator;

    private BookDTO bookDTO;
    private Book book;

    @BeforeEach
    void setUp() {
        bookDTO = BookTestData.getSampleBookDTO();
        book = BookTestData.getSampleBook();
    }

    @Test
    void createBook_success() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedBook = bookService.createBook(bookDTO);

        assertNotNull(savedBook);
        assertEquals(BOOK_TITLE, savedBook.getTitle());
        verify(bookValidator, times(1)).validate(bookDTO);
        verify(isbnValidator, times(1)).validate(bookDTO.getIsbn());
    }

    @Test
    void getBookById_success() {
        when(bookRepository.findByIdAndActive(BOOK_ID, true)).thenReturn(book);

        Book foundBook = bookService.getBookById(BOOK_ID);

        assertNotNull(foundBook);
        assertEquals(BOOK_TITLE, foundBook.getTitle());
    }

    @Test
    void getBookById_notFound() {
        when(bookRepository.findByIdAndActive(BOOK_ID, true)).thenReturn(null);

        assertThrows(BadRequestException.class, () -> bookService.getBookById(BOOK_ID));
    }

    @Test
    void updateBook_success() {
        when(bookRepository.findByIdAndActive(BOOK_ID, true)).thenReturn(book);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookDTO updatedBookDTO = new BookDTO();
        updatedBookDTO.setTitle(UPDATED_TITLE);
        updatedBookDTO.setIsbn(UPDATED_ISBN);
        updatedBookDTO.setPublisher(UPDATED_PUBLISHER);
        updatedBookDTO.setPrice(UPDATED_PRICE);

        Book updatedBook = bookService.updateBook(BOOK_ID, updatedBookDTO);

        assertNotNull(updatedBook);
        assertEquals(UPDATED_TITLE, updatedBook.getTitle());
        verify(bookValidator, times(1)).validate(updatedBookDTO);
        verify(isbnValidator, times(1)).validate(updatedBookDTO.getIsbn());
    }

    @Test
    void deleteBook_success() {
        when(bookRepository.findByIdAndActive(BOOK_ID, true)).thenReturn(book);

        bookService.deleteBook(BOOK_ID);

        verify(bookRepository, times(1)).save(book);
        assertFalse(book.getActive());
    }

    @Test
    void deleteBook_notFound() {
        when(bookRepository.findByIdAndActive(BOOK_ID, true)).thenReturn(null);

        assertThrows(BadRequestException.class, () -> bookService.deleteBook(BOOK_ID));
    }
}
