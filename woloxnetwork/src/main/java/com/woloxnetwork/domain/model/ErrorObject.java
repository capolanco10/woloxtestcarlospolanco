package com.woloxnetwork.domain.model;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {

	@JsonProperty("message")
	private String message;
	
	@JsonProperty("status_code")
	private int statusCode;
	
	@JsonProperty("uri")
	private String uriRequested;

	public ErrorObject(Integer statusCode, MethodArgumentNotValidException exception, String uriRequested) {
	       this.message = exception.getMessage();
	       this.statusCode = statusCode;
	       this.uriRequested = uriRequested;
   }

	public ErrorObject(Integer statusCode, String message, String uriRequested) {
	       this.message = message;
	       this.statusCode = statusCode;
	       this.uriRequested = uriRequested;
	   }

	public ErrorObject(Integer statusCode, String message) {
	       this.message = message;
	       this.statusCode = statusCode;
	   }

}
