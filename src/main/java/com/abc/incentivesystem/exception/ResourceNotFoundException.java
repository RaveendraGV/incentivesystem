package com.abc.incentivesystem.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 749030709210977042L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
