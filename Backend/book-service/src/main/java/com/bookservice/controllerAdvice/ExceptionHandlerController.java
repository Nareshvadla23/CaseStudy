package com.bookservice.controllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> HandlingException(MethodArgumentNotValidException exception) {

		Map<String, String> error = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach(err -> {
			String fieldError = ((FieldError) err).getField();
			String message = ((FieldError) err).getDefaultMessage();
			error.put(fieldError, message);
		});
		return new ResponseEntity<Map<String, String>>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
