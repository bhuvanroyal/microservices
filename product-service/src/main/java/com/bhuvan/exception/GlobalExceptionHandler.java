package com.bhuvan.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ResponseBody
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> ProductNotFoundExceptionHandling(Exception e, WebRequest request) {
		ErrorDetails errorResponse=new ErrorDetails();
		errorResponse.setMessage(e.getMessage());
		errorResponse.setPath(request.getDescription(false));
		errorResponse.setTimeStamp(LocalDateTime.now());
		errorResponse.setStatusCode("NOT_FOUND");
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
