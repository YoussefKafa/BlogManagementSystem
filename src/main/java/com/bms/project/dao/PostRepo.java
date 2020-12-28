package com.bms.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bms.project.models.Post;

@Repository
public interface PostRepo extends CrudRepository<Post , Long> {

	
	
}
