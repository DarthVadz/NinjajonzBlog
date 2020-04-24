package com.nj.NinjajonzBlog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comment_id")
	private Long id;
	
	@OneToMany(mappedBy= "comment")
	private User author;
	
	@OneToMany(mappedBy = "comment")
	@Length(max=250, message="Your password cannot exceed 250 characters")
	private String text;
	
	@CreationTimestamp
	private Date createdAt;
	
}
