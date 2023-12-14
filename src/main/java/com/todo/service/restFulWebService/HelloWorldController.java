package com.todo.service.restFulWebService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	
	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World Bean "+name);
	}
	
	//http://localhost:8080/hello-world-bean/hamza/and/abdullah
	@GetMapping("/hello-world-bean/{name1}/and/{name2}")
	public HelloWorldBean helloWorldBeanPathVariableTwoNames(@PathVariable String name1,@PathVariable String name2) {
		return new HelloWorldBean("Hello World Bean "+name1 +" && "+name2);
	}

}
