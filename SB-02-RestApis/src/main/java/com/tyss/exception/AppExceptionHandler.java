package com.tyss.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> catchException(ArithmeticException e) {
		System.out.println("AE handled Globally");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> catchNullPointerException(NullPointerException e) {
		System.out.println("Hanlde NPE");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> catchException(Exception e) {
		System.out.println("handle all exception");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
}
