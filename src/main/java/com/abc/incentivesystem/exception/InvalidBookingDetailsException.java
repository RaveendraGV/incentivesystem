package com.abc.incentivesystem.exception;

@SuppressWarnings("serial")
public class InvalidBookingDetailsException extends RuntimeException {

	public InvalidBookingDetailsException(String message) {
		super(message);
	}
}
