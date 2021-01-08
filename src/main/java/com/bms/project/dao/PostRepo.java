package com.bms.project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bms.project.models.Post;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

	Optional<Post> findByIdAndUserId(Long id, Long userId);

}