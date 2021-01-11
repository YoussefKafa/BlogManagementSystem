package com.bms.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bms.project.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	@Query("select u from User u where u.name like %?1")
	List<User> findUsersByName(String name);

	@Query("select u from User u where u.email = ?1")
	User findUserByEmail(String email);
}