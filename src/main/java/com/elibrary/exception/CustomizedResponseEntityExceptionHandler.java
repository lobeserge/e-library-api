package com.elibrary.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionResponse exceptionresponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
	return new ResponseEntity(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(UserNotFound.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFound ex, WebRequest request) throws Exception {
		
		ExceptionResponse exceptionresponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
	return new ResponseEntity(exceptionresponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BookNotFound.class)
	public final ResponseEntity<Object> handleUserNotFoundException(BookNotFound ex, WebRequest request) throws Exception {
		
		ExceptionResponse exceptionresponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
	return new ResponseEntity(exceptionresponse,HttpStatus.NOT_FOUND);
		
	}
}