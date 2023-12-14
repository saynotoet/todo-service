package com.todo.service.restFulWebService;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {

	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDaoService userDaoService;

	@GetMapping(path="/users", headers = "Authorization")
	public List<User> getAllUsers(@RequestHeader("Authorization") String authorizationHeader) {
		logger.info("Header's valus is: " +authorizationHeader);
		return userDaoService.findAll();
	}
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> findOne(@PathVariable int id) {
		User user = userDaoService.findOne(id);

		if (null == user) {
			throw new UserNotFoundExcpetion("User not found, id:" + id);
		}

		EntityModel<User> entityModel= EntityModel.of(user);
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userDaoService.deleteUserById(id);

	}

	//@RequestHeader("Authorization") String authorizationHeader, @RequestHeader(name = "Content-Type", defaultValue = "application/json") String contentTypeHeader
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		user = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
