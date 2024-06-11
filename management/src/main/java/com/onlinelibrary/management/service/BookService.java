package com.onlinelibrary.management.service;

import com.onlinelibrary.management.dto.BookDTO;
import com.onlinelibrary.management.model.Book;

/**
 * Service interface for managing books.
 */
public interface BookService {

    /**
     * Creates a new book.
     *
     * @param bookDTO the DTO containing the details of the book to create
     * @return the created book
     */
	Book createBook(BookDTO bookDTO);

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return the found book
     */
	Book getBookById(Long id);

    /**
     * Updates an existing book.
     *
     * @param id the ID of the book to update
     * @param bookDTO the DTO containing the updated details of the book
     * @return the updated book
     */
    Book updateBook(Long id, BookDTO bookDTO);

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete
     */
    void deleteBook(Long id);
}
