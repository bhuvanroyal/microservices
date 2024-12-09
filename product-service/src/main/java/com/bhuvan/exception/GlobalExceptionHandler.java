package com.bhuvan.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
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
	
	@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																	HttpHeaders headers, 
																	HttpStatusCode status, 
																	WebRequest request) {
			Map<String,String> errors=new HashMap<>();
			List<ObjectError> errorList= ex.getBindingResult().getAllErrors();
			errorList.forEach((error)->{
				String fieldName=((FieldError) error).getField();
				String message= error.getDefaultMessage();
				errors.put(fieldName, message);
			});
			return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		}

}
