package com.todo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMain.class, args);
	}

}
