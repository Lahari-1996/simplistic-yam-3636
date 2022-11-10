package com.ayushkaam.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobaExceptionHandler {

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionBody> exceptionHandler(Exception exception , WebRequest webRequest) {
		
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(LocalDateTime.now() , exception.getMessage() , webRequest.getDescription(false)) , HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionBody> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req) {
		
		ExceptionBody err = new ExceptionBody(LocalDateTime.now(), "Not Valid URL" , req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionBody> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		ExceptionBody err=new ExceptionBody(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<ExceptionBody>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<ExceptionBody> memberExceptionHandler(MemberException memberException , WebRequest webRequest) {
		
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(LocalDateTime.now() , memberException.getMessage() , webRequest.getDescription(false)) , HttpStatus.BAD_REQUEST);
	}
}
