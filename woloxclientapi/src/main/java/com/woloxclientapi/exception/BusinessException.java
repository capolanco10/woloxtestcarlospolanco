package com.woloxclientapi.exception;

public class BusinessException extends RuntimeException{

	public BusinessException(String reasonPhrase) {
		super(reasonPhrase);
	}

}
