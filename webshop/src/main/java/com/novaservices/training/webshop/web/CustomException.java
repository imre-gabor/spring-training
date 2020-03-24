package com.novaservices.training.webshop.web;

public class CustomException extends RuntimeException {
	
	private int code;

	public CustomException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
