package com.bms.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bms.project.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	
}
