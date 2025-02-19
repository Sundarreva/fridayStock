package com.cognizant.authenticationservice.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception{
	
	String message;

	public UserAlreadyExistException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
