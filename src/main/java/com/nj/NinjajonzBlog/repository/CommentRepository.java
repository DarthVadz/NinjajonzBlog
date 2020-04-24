package com.nj.NinjajonzBlog.repository;

import java.util.List;

import com.nj.NinjajonzBlog.model.Comment;

public interface CommentRepository {
	List<Comment> findAllByOrderByCreatedAtDesc();

}
