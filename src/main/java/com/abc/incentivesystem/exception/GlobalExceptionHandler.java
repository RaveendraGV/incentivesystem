package com.abc.incentivesystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(DuplicateBookingException.class)
	public ResponseEntity<String> handleDuplicateBookingException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(InvalidBookingDetailsException.class)
	public ResponseEntity<String> handleInvalidBookingDetailsException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(BookingNotExistException.class)
	public ResponseEntity<String> handleBookingNotExistException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

}
