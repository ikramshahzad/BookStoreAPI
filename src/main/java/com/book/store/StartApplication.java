package com.book.store;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.book.store.model.Book;
import com.book.store.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class StartApplication {
	private static final Logger logger = LoggerFactory.getLogger(StartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookService bookService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {
			};

			logger.info("Loading resources (" + "/books-mock.json" + ")");
			InputStream inputstream = TypeReference.class.getResourceAsStream("/books-mock.json");
			List<Book> books = mapper.readValue(inputstream, typeReference);
			bookService.createBook(books);
			logger.info("resources loaded succesfully");
			logger.info("System, is ready ...!!");
		};

	}
}
