package com.novaservices.training.webshop.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(CustomException ex){
		CustomErrorMessage customErrorMessage = new CustomErrorMessage();
		customErrorMessage.setCode(ex.getCode());
		customErrorMessage.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(customErrorMessage);
	}
}
