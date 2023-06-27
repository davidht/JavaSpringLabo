package com.javaspringlabo.monproject.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> handleNodataFoundException(NoDataFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("NoDataFoundException ", LocalDateTime.now());
		body.put("message: ", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadDateException.class)
	public ResponseEntity<Object> handleBadDateException(BadDateException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("BadDateException ", LocalDateTime.now());
		body.put("message: ", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
