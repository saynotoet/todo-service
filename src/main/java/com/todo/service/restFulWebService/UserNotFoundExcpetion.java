package com.todo.service.restFulWebService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class UserNotFoundExcpetion extends RuntimeException {

	public UserNotFoundExcpetion(String message) {
		super(message);
	}
	
}
