package com.book.store.exception;

import com.book.store.constant.ErrorCode;

public class BookAlreadyExistException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public BookAlreadyExistException(String id) {
		super(ErrorCode.BOOK_ALREADY_EXIST.getCode(), ErrorCode.BOOK_ALREADY_EXIST.getDescription(),
				new Object[] { id });
	}

}
