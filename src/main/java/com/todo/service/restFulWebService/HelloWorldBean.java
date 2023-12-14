package com.todo.service.restFulWebService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldBean {

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	@JsonProperty("Message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
