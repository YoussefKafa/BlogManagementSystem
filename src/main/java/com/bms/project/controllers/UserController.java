package com.bms.project.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.project.models.User;
import com.bms.project.services.PostServices;
import com.bms.project.services.UserServices;

@RestController
public class UserController {
	@Autowired
	public UserServices userServices;
	@Autowired
	public PostServices postServices;

	@GetMapping("/api/user/count")
	public ResponseEntity<?> count() {
		long result = userServices.count();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/api/user/save")
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		User result = userServices.save(user);
		return new ResponseEntity<User>(result, HttpStatus.OK);
	}

	@GetMapping("/api/user/findById/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable long id) {
		Optional<User> result = userServices.findById(id);
		return new ResponseEntity<Optional<User>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/user/findAll")
	public ResponseEntity<Iterable<User>> findAll() {
		Iterable<User> result = userServices.findAll();
		return new ResponseEntity<Iterable<User>>(result, HttpStatus.OK);
	}

	@DeleteMapping("/api/user/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		userServices.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/api/user/deleteAll")
	public ResponseEntity<Void> deleteAll() {
		userServices.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/api/user/update/{userId}")
	public ResponseEntity<Optional<User>> update(@PathVariable long userId, @Valid @RequestBody User user) {
		Optional<User> result = userServices.update(userId, user);
		return new ResponseEntity<Optional<User>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/user/findUsersByName/{userName}")
	public ResponseEntity<List<User>> findUsersByName(@PathVariable String userName) {
		List<User> result = userServices.findUsersByName(userName);
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/user/findUserByEmail/{userEmail}")
	public ResponseEntity<User> findUserByEmail(@PathVariable String userEmail) {
		User result = userServices.findUserByEmail(userEmail);
		return new ResponseEntity<User>(result, HttpStatus.OK);
	}
}
