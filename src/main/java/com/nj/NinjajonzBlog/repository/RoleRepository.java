package com.nj.NinjajonzBlog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nj.NinjajonzBlog.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);

}
