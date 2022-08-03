package com.book.store.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.model.Book;

@Service
public class OperationService {
	private BookService bookService;

	@Autowired
	public OperationService(BookService bookService) {
		this.bookService = bookService;
	}

	public BigDecimal checkout(Book book, Optional<String> code) {
		BigDecimal payable = bookService.findByid(book.getId()).getPrice();
		if (code.orElse("").equals(book.getType())) {
			payable = payable.subtract(payable.multiply(BigDecimal.valueOf(0.15)));
		}
		return payable;
	}

	public BigDecimal checkout(List<Book> books, Optional<String> code) {
		BigDecimal payable = BigDecimal.ZERO;
		for (Book book : books) {
			payable = payable.add(checkout(book, code));
		}
		return payable;
	}
}
