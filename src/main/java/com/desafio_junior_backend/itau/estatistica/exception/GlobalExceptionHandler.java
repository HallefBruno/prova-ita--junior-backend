package com.desafio_junior_backend.itau.estatistica.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<FieldMessage> fieldMessages = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			fieldMessages.add(new FieldMessage(fieldError.getField(), fieldError.getDefaultMessage()));
		}
        return new ResponseEntity<>(new ResponseError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", fieldMessages), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
		if(ex instanceof HttpMessageNotReadableException) {
			return new ResponseEntity<>(ResponseError.responseMessageBadRequest(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ResponseError.responseMessageBadRequest(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
