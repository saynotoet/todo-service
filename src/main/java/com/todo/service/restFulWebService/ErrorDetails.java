package com.todo.service.restFulWebService;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timestamps;
	private String message;
	private String description;
	public ErrorDetails(LocalDateTime timestamps, String message, String description) {
		super();
		this.timestamps = timestamps;
		this.message = message;
		this.description = description;
	}
	public LocalDateTime getTimestamps() {
		return timestamps;
	}
	public void setTimestamps(LocalDateTime timestamps) {
		this.timestamps = timestamps;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
