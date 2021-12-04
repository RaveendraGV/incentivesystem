package com.abc.incentivesystem.exception;

public class DuplicateBookingException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -235818582769302818L;

	public DuplicateBookingException(String message) {
		super(message);
	}
}
