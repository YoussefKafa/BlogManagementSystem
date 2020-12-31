package com.bms.project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bms.project.models.User;
import com.bms.project.services.UserServices;

@RestController
public class UserController {
	@Autowired
	public UserServices userServices;

	@GetMapping("/api/user/count")
	public long count() {
		return userServices.count();
	}

	@DeleteMapping("/api/user/dleteById/{id}")
	public void deletById(@PathVariable long id) {
		userServices.deleteById(id);
	}

	@DeleteMapping("/api/user/deleteAll")
	public void deleteAll() {
		userServices.deleteAll();
	}

	@GetMapping("/api/user/fingById/{id}")
	public Optional<User> findById(@PathVariable long id) {
		return userServices.findById(id);
	}

	@GetMapping("/api/user/deleteAll")
	public Iterable<User> findAll() {
		return userServices.findAll();
	}

}
