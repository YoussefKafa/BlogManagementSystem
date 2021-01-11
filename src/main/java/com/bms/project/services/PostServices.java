package com.bms.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.project.models.Post;
import com.bms.project.models.User;
import com.bms.project.payload.UpdatePostContentRequest;
import com.bms.project.repo.PostRepo;

import java.util.Optional;

@Service
public class PostServices {
	@Autowired
	public PostRepo postRepo;
	@Autowired
	public UserServices userServices;

	public Post saveOrUpdate(final Post post) {
		return postRepo.save(post);
	}

	public long count() {
		return postRepo.count();
	}

	public void deleteById(Long id) {
		postRepo.deleteById(id);
	}

	public void deleteAll() {
		postRepo.deleteAll();
	}

	public Optional<Post> findById(long id) {
		return postRepo.findById(id);
	}

	public Iterable<Post> findAll() {
		return postRepo.findAll();
	}

	public Optional<Post> update(long userId, Post post) {
		User user = userServices.findById(userId).get();
		post.setUser(user);
		this.saveOrUpdate(post);
		return Optional.ofNullable(post);
	}

	public Post updateContent(long postId, UpdatePostContentRequest updatePostContentRequest) {
		Post post = postRepo.findById(postId).get();
		post.setContent(updatePostContentRequest.getContent());
		this.saveOrUpdate(post);
		return post;
	}
}