package com.bms.project.controllers;

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

import com.bms.project.models.Post;
import com.bms.project.payload.UpdatePostContentRequest;
import com.bms.project.services.PostServices;
import com.bms.project.services.UserServices;

@RestController
public class PostController {
	@Autowired
	public PostServices postServices;
	@Autowired
	public UserServices userServices;

	@GetMapping("/api/post/count")
	public ResponseEntity<?> count() {
		long result = postServices.count();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/api/post/save/{userId}")
	public ResponseEntity<Optional<Post>> save(@Valid @RequestBody Post post, @PathVariable Long userId) {
		Optional<Post> result = userServices.findById(userId).map(user -> {
			post.setUser(user);
			return postServices.saveOrUpdate(post);
		});
		return new ResponseEntity<Optional<Post>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/post/findById/{postId}")
	public ResponseEntity<Optional<Post>> findById(@PathVariable Long postId) {
		Optional<Post> result = postServices.findById(postId);
		return new ResponseEntity<Optional<Post>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/post/findAll")
	public ResponseEntity<Iterable<Post>> findAll() {
		Iterable<Post> result = postServices.findAll();
		return new ResponseEntity<Iterable<Post>>(result, HttpStatus.OK);
	}

	@DeleteMapping("/api/post/deleteById/{postId}")
	public ResponseEntity<Void> deleteById(@PathVariable Long postId) {
		postServices.deleteById(postId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/api/post/deleteAll")
	public ResponseEntity<Void> deleteAll() {
		postServices.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/api/post/update/{userId}")
	public ResponseEntity<Optional<Post>> update(@PathVariable long userId, @Valid @RequestBody Post post) {
		Optional<Post> result = postServices.update(userId, post);
		return new ResponseEntity<Optional<Post>>(result, HttpStatus.OK);
	}

	@PutMapping("/api/post/updateContent/{postId}")
	public ResponseEntity<Post> updateContent(@PathVariable long postId,
			@Valid @RequestBody UpdatePostContentRequest updatePostContentRequest) {
		Post result = postServices.updateContent(postId, updatePostContentRequest);
		return new ResponseEntity<Post>(result, HttpStatus.OK);
	}
}