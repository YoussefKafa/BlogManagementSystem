package com.bms.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bms.project.dao.PostRepo;
import com.bms.project.dao.UserRepo;
import com.bms.project.models.Post;
import com.bms.project.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
	@Autowired
	public UserRepo userRepo;

	public long count() {
		return userRepo.count();
	}

	public User save(User user) {
		return userRepo.save(user);
	}

	public void deleteById(long id) {
		userRepo.deleteById(id);
	}

	public void deleteAll() {
		userRepo.deleteAll();
	}

	public Optional<User> findById(long id) {
		return userRepo.findById(id);
	}

	public Iterable<User> findAll() {
		return userRepo.findAll();
	}

}
