package com.bms.project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bms.project.models.Post;
import com.bms.project.models.User;
import com.bms.project.services.UserServices;

@RestController
public class UserController {
	@Autowired
	public UserServices userServices;

	@GetMapping("/api/user/count")
	public ResponseEntity<?> count() {
		long result = userServices.count();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/api/user/dleteById/{id}")
	public ResponseEntity<Void> deletById(@PathVariable long id) {
		userServices.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/api/user/deleteAll")
	public ResponseEntity<Void> deleteAll() {
		userServices.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/api/user/fingById/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable long id) {
		Optional<User> result = userServices.findById(id);
		return new ResponseEntity<Optional<User>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/user/deleteAll")
	public ResponseEntity<Iterable<User>> findAll() {
		Iterable<User> result = userServices.findAll();
		return new ResponseEntity<Iterable<User>>(result, HttpStatus.OK);
	}

}
