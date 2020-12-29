package com.bms.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bms.project.services.PostServices;

@RestController
public class PostController {
@Autowired
public PostServices postServices;
	@GetMapping("/api/post/count")
	public long count() {
		return postServices.count();
		
	}
	@DeleteMapping("/api/post/deleteById/{id}")
	public void deleteById(@PathVariable Long id) {
		 postServices.deleteById(id);
	}
	
}
