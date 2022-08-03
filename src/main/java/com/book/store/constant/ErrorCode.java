package com.book.store.constant;

public enum ErrorCode implements ErrorMessage {
	BOOK_DOES_NOT_EXIST("ERR_ACC_B_0002", "Book {0} does not exist."),
	BOOK_ALREADY_EXIST("ERR_ACC_B_0005", "Book {0} already exist."),;

	private ErrorCode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	private String code;
	private String description;

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

}
