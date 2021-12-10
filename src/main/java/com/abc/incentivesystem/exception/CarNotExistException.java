package com.abc.incentivesystem.exception;

@SuppressWarnings("serial")
public class CarNotExistException extends RuntimeException {

	public CarNotExistException(String message) {
		super(message);
	}
}
