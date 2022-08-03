package com.book.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.exception.BookAlreadyExistException;
import com.book.store.exception.BookDoesNotExistException;
import com.book.store.model.Book;
import com.book.store.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book createBook(Book book) {
		bookRepository.findById(book.getId()).ifPresent(c -> {
			throw new BookAlreadyExistException(book.getId());
		});
		return bookRepository.save(book);
	}

	public void createBook(List<Book> book) {
		book.forEach(element -> {
			createBook(element);
		});
	}

	public Book findByid(String id) {
		return bookRepository.findById(id).orElseThrow(() -> new BookDoesNotExistException(id));
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Optional<Book> getBookById(String id) {
		return bookRepository.getBookById(id);
	}

	public Book updateBook(String id, Book book) {
		bookRepository.findById(id).orElseThrow(() -> new BookDoesNotExistException(id));
		book.setId(id);
		return bookRepository.save(book);
	}

	public void delete(String id) {
		bookRepository.delete(bookRepository.findById(id).orElseThrow(() -> new BookDoesNotExistException(id)));
	}

	public void delete(Book book) {
		delete(book.getId());
	}
	

//	public void updateBalance(Account account, Transaction transaction) {
//		if (account.getId().equals(transaction.getDebitId())) {
//			if (account.getBalance().compareTo(transaction.getAmount()) < 0) {
//				throw new InsufficientBalanceException(account.getId());
//			}
//			account.setBalance(account.getBalance().subtract(transaction.getAmount()));
//		} else if (account.getId().equals(transaction.getCreditId())) {
//			account.setBalance(account.getBalance().add(transaction.getAmount()));
//		}
//	}
}
