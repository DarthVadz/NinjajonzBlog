package com.nj.NinjajonzBlog.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.nj.NinjajonzBlog.model.Zips;

@Repository
public interface ZipCodeRepository extends CrudRepository<Zips, Long> {
	List<Zips> findAll();
	List<Zips> findAllByOrderByCreatedAtDesc();
}
