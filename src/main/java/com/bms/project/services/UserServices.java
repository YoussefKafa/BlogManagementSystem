package com.bms.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.bms.project.dao.UserRepo;
import com.bms.project.models.User;

import java.util.Optional;

import javax.validation.Valid;

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

	public void deleteById(long userId) {
		userRepo.deleteById(userId);
	}

	public void deleteAll() {
		userRepo.deleteAll();
	}

	public Optional<User> findById(long userId) {
		return userRepo.findById(userId);
	}

	public Iterable<User> findAll() {
		return userRepo.findAll();
	}

	public Optional<User> update(@PathVariable long userId, @Valid @RequestBody User user) {
		userRepo.save(user);
		return Optional.ofNullable(user);
	}
}