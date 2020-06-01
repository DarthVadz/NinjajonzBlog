package com.nj.NinjajonzBlog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.NinjajonzBlog.model.Article;
import com.nj.NinjajonzBlog.model.Comment;
import com.nj.NinjajonzBlog.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	public ArticleRepository articleRepository;
	
	public Article saveNewArticle(Article article) {
		return articleRepository.save(article);
	}
	
	public List<Article> findAll() {
		List<Article> articleList = articleRepository.findAllByOrderByCreatedAtDesc();
		return articleList;
	}
	
	public Optional<Article> findById(Long id) {
		return articleRepository.findById(id);
	}
	
	// public String makePreview(Article article) {
	// 	String message = article.getMessage();
	// 	String preview = new String();
	// 	if(message.length() > 20) {
	// 		preview = message.substring(0, 20);
	// 	} else {
	// 		preview = message;
	// 	}
	// 	return preview;
	// }

	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
