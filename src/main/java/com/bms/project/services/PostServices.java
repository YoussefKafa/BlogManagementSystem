package com.bms.project.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.project.dao.PostRepo;
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
}
