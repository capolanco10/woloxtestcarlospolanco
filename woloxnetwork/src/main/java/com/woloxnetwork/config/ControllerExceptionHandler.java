/**
 * @autor CACP 
 */
package com.woloxnetwork.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.woloxnetwork.domain.model.ErrorObject;


/**
 * @autor luxos CACP
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		StringBuilder error = new StringBuilder().append(ConstantsMessage.HTTPSTATUS_ERROR_EXCEPTIONHANDLER);
		for (ObjectError fieldError : ex.getBindingResult().getAllErrors()) {
			error.append(fieldError.getDefaultMessage() + StringUtils.SPACE);
		}
		logger.error(ConstantsMessage.HTTPSTATUS_ERROR_EXCEPTIONHANDLER, ex);
		return new ResponseEntity<>(new ErrorObject(HttpStatus.BAD_REQUEST.toString(), error.toString()),HttpStatus.BAD_REQUEST);
	}
}
