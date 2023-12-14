package com.todo.service.restFulWebService;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	public User(int id, String name, LocalDate age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@JsonIgnore
	private int id;
	
	@Size(min=2 , message="Minimum length of name is 2")
	private String name;
	
	@JsonProperty("Birth-date")
	@Past(message="Date should be in the past")
	private LocalDate age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getAge() {
		return age;
	}
	public void setAge(LocalDate age) {
		this.age = age;
	}
	


}
