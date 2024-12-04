package com.bhuvan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception{

	String msg;
	public ProductNotFoundException(String msg) {
		super(msg);
	}
	
}
