package com.book.store.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.model.Book;
import com.book.store.service.OperationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/operation")
@Api(tags = { "Operation" }, value = "API for related to operation")
public class OperationController {

	private OperationService operationService;

	@Autowired
	public OperationController(OperationService operationService) {
		this.operationService = operationService;
	}

	@PostMapping("/{code}")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "API for Checkout with promotion/discounts", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 400, message = "Book does not exist."),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Book.class) })
	public BigDecimal checkout(@PathVariable(value = "code") String code, @RequestBody @Valid List<Book> books) {
		return operationService.checkout(books, Optional.of(code));
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "API for Checkout without Promotion/Discounts", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 400, message = "Book does not exist."),
			@ApiResponse(code = 200, message = "Successful retrieval", response = Book.class) })
	public BigDecimal checkout(@RequestBody @Valid List<Book> books) {
		return operationService.checkout(books, Optional.empty());
	}
}
