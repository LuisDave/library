package com.onlinelibrary.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinelibrary.management.model.Book;

/**
 * Repository interface for managing {@link Book} entities.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Checks if a book with the given ISBN and active status exists.
     *
     * @param isbn the ISBN of the book
     * @param active the active status of the book
     * @return true if a book with the given ISBN and active status exists, false otherwise
     */
    boolean existsByIsbnAndActive(String isbn, boolean active);

    /**
     * Finds a book by its ID and active status.
     *
     * @param id the ID of the book
     * @param active the active status of the book
     * @return the book with the given ID and active status, or null if no such book exists
     */
    Book findByIdAndActive(Long id, boolean active);
}
