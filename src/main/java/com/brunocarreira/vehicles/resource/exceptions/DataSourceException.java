package com.brunocarreira.vehicles.resource.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bruno Carreira
 * 
 * Exception class to send a response NOT_FOUND to the client.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataSourceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataSourceException(String msg){
		super(msg);
	}
}

