package com.book.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.model.Book;
import com.book.store.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/book")
@Api(tags = { "Book" }, value = "API for book related operation")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "API for create an book", response = Book.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 400, message = "Book already exist."),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Book.class) })
	public Book createBook(@Valid @RequestBody Book book) {
		return bookService.createBook(book);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "API for fetch book", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 400, message = "Book does not exist."),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Book.class) })
	public Book getBook(@PathVariable("id") String id) {
		return bookService.findByid(id);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "API for fetch all book", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Book.class, responseContainer = "List") })
	public List<Book> getAllBook() {
		return bookService.findAll();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "API for update book", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 400, message = "Book does not exist."),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Book.class) })
	public Book updateBook(@PathVariable(value = "id") String id, @Valid @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "API for delete book", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 400, message = "Book does not exist."),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval") })
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") String id) {
		bookService.delete(id);
		return ResponseEntity.ok().build();
	}
}
