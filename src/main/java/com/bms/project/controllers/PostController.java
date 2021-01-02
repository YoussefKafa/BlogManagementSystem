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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bms.project.models.Post;
import com.bms.project.services.PostServices;
@RestController
public class PostController {
	@Autowired
	public PostServices postServices;
		@PostMapping("/api/post/save")
	public ResponseEntity<?> save(@Valid @RequestBody Post post){
		 postServices.saveOrUpdate(post);
		 return new ResponseEntity<Post>(post,HttpStatus.CREATED);
	}
	@GetMapping("/api/post/count")
	public long count() {
		return postServices.count();
	}

	@DeleteMapping("/api/post/deleteById/{id}")
	public void deleteById(@PathVariable Long id) {
		postServices.deleteById(id);
	}

	@DeleteMapping("/api/post/deleteAll")
	public void deleteAll() {
		postServices.deleteAll();
	}

	@GetMapping("/api/post/findById/{id}")
	public Optional<Post> findById(@PathVariable Long id) {
		return postServices.findById(id);
	}

	@GetMapping("/api/post/findAll")
	public Iterable<Post> findAll() {
		return postServices.findAll();
	}
}
