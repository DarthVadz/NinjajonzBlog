package com.nj.NinjajonzBlog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private User author;
	
	private String title;
	
	@Length(max=1500, message="Your message cannot exceed 1500 characters")
	private String message;
	
	@CreationTimestamp
	private Date createdAt;
	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "article_tag", joinColumns = @JoinColumn(name = "article_id"),
//	    inverseJoinColumns = @JoinColumn(name = "comment_id"))
//	private List<Comment> comments;

	public Article(User author, String title,
			@Length(max = 1500, message = "Your password cannot exceed 1500 characters") String message, String preview,
			Date createdAt) {
		this.author = author;
		this.title = title;
		this.message = message;
		this.createdAt = createdAt;
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPreview(String message) {
		String preview;
		if(message.length() > 30) {
			preview = message;
		} else {
			preview = (message.substring(0, 30));
		}
		return preview;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}
	
}
