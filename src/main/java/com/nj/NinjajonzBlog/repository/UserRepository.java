package com.nj.NinjajonzBlog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nj.NinjajonzBlog.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	User findByUsername(String username);

}
