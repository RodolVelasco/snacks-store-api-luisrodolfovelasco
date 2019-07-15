package com.applaudo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.applaudo.api.exception.*;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(value = ProductsPaginationSortingException.class)
	public ResponseEntity<String> ProductsPaginationSortingException(Exception ex) throws Exception {
		this.logger.error("Products pagination sorting exception");
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.PRECONDITION_FAILED);
	}
}
