package com.book.store.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.store.model.Book;

@Repository
@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, String> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Transactional
	@Query("SELECT a FROM Book a WHERE a.id = ?1")
	Optional<Book> getBookById(String id);

}
