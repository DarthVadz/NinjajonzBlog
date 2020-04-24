package com.nj.NinjajonzBlog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nj.NinjajonzBlog.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

	List<Article> findAllByOrderByCreatedAtDesc();
	Optional<Article> findById(Long article_id);
	
}
