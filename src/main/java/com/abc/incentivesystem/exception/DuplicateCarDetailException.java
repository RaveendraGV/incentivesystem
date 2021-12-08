package com.abc.incentivesystem.exception;

public class DuplicateCarDetailException extends RuntimeException {

	private static final long serialVersionUID = -235818582769302818L;
	public DuplicateCarDetailException (String message) {
		super(message);
	}
}
