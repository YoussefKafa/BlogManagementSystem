package com.bms.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.project.dao.PostRepo;
import com.bms.project.models.Post;
import java.util.Optional;

@Service
public class PostServices {
	@Autowired
	public PostRepo postRepo;

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


}
