package com.bms.project.controllers;

import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.project.dao.UserRepo;
import com.bms.project.models.Post;
import com.bms.project.services.PostServices;

@RestController
public class PostController {
	@Autowired
	public PostServices postServices;
	@Autowired
	public UserRepo userRepo;

	@GetMapping("/api/post/count")
	public ResponseEntity<?> count() {
		long result = postServices.count();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/api/post/save/{userId}")
	public ResponseEntity<?> save(@Valid @RequestBody Post post,@PathVariable Long userId) throws RelationNotFoundException {
		 return userRepo.findById(userId).map(user -> {
	            post.setUser(user);
	        	postServices.saveOrUpdate(post);
	    		return new ResponseEntity<Post>(post, HttpStatus.CREATED);
	        }).orElseThrow(() -> new RelationNotFoundException("instructor not found"));
	
	}

	@DeleteMapping("/api/post/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		postServices.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/api/post/deleteAll")
	public ResponseEntity<Void> deleteAll() {
		postServices.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/api/post/findById/{id}")
	public ResponseEntity<Optional<Post>> findById(@PathVariable Long id) {
		Optional<Post> result = postServices.findById(id);
		return new ResponseEntity<Optional<Post>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/post/findAll")
	public ResponseEntity<Iterable<Post>> findAll() {
		Iterable<Post> result = postServices.findAll();
		return new ResponseEntity<Iterable<Post>>(result, HttpStatus.OK);
	}
}
