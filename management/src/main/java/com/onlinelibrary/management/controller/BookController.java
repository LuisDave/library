package com.onlinelibrary.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinelibrary.management.dto.BookDTO;
import com.onlinelibrary.management.model.Book;
import com.onlinelibrary.management.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Operations pertaining to books in Library")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	@Operation(summary = "Add a new book", description = "Create a new book in the library. The request body should contain all the necessary book details.")
	public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
		Book createdBook = bookService.createBook(bookDTO);
		return ResponseEntity.ok(createdBook);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get a book by ID", description = "Retrieve a book by its ID.")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Book book = bookService.getBookById(id);
		return ResponseEntity.ok(book);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update a book by ID", description = "Update an existing book by its ID. The request body should contain the book details to be updated.")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
		Book updatedBook = bookService.updateBook(id, bookDTO);
		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a book by ID", description = "Mark a book as inactive by its ID.")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}

}