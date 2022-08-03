package com.book.store.exception;

import com.book.store.constant.ErrorCode;

public class BookDoesNotExistException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public BookDoesNotExistException(String id) {
		super(ErrorCode.BOOK_DOES_NOT_EXIST.getCode(), ErrorCode.BOOK_DOES_NOT_EXIST.getDescription(),
				new Object[] { id });
	}

}
