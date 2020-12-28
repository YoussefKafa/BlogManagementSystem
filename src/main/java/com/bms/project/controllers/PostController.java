package com.bms.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.project.services.PostServices;

@RestController
public class PostController {
@Autowired
public PostServices postServices;
	@GetMapping("/post/count")
	public long count() {
		return postServices.count();
		
	}
}
