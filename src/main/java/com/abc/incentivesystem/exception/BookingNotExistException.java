package com.abc.incentivesystem.exception;

@SuppressWarnings("serial")
public class BookingNotExistException extends RuntimeException {

	public BookingNotExistException(String message) {
		super(message);
	}
}
