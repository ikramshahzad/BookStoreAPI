package com.book.store;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.book.store.model.Book;
import com.book.store.repository.BookRepository;
import com.book.store.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	@Mock
	BookRepository bookRepository;

	@InjectMocks
	BookService bookService;

	@Test
	public void testGetBook() {
		String id = new String("3d253e29-8785-464f-8fa0-9e4b57699db9");
		String name = new String("Junit");
		String description = new String("Junit");
		String author = new String("Junit");
		String type = new String("fiction");
		String isbn = new String("Junit");
		BigDecimal price = new BigDecimal("1000");

		Book book = new Book(id, name, description, author, type, price, isbn);

		when(bookRepository.findById(id)).thenReturn(Optional.of(book));

		assertEquals(BigDecimal.TEN, bookService.findByid(id).getPrice());
	}

}
