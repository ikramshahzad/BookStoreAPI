package com.book.store.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.book.store.constant.FieldNameLength;

@Entity
@Table(name = "BN_MS_BOOK")
public class Book {

	@Id
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = FieldNameLength.CODE_50)
	private String id;
	@Column(name = "name", nullable = false, updatable = true, columnDefinition = FieldNameLength.CODE_200)
	private String name;
	@Column(name = "description", nullable = false, updatable = true, columnDefinition = FieldNameLength.CODE_200)
	private String description;
	@Column(name = "author", nullable = false, updatable = true, columnDefinition = FieldNameLength.CODE_200)
	private String author;
	@Column(name = "type", nullable = false, updatable = true, columnDefinition = FieldNameLength.CODE_200)
	private String type;

	@Column(name = "price", columnDefinition = FieldNameLength.AMOUNT_REAL)
	@Min(value = 0, message = "price must be positive")
	private BigDecimal price = BigDecimal.ZERO;
	@Column(name = "isbn", nullable = false, updatable = true, columnDefinition = FieldNameLength.CODE_200)
	private String isbn;
	@Column(name = "VERSION_NUM")
	@Version
	private int version;

	public Book() {
	}

	public Book(@NotNull String id, @NotNull String name, @NotNull String description, @NotNull String author,
			@NotNull String type, @NotNull @Min(value = 0, message = "price must be positive") BigDecimal price,
			@NotNull String isbn) {
		this.id = id;
		this.name = name;

		this.description = description;
		this.author = author;
		this.type = type;
		this.price = price;
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", author=" + author + ", type="
				+ type + ", price=" + price + ", isbn=" + isbn + ", version=" + version + "]";
	}

}
