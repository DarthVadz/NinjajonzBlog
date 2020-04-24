package com.nj.NinjajonzBlog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Zips {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zip_id")
	private Long id;
	
	@CreationTimestamp
	private Date createdAt;
	
	private String zipCode;

	public Zips() {	}

	public Zips(Date createdAt, String zipCode) {
		this.createdAt = createdAt;
		this.zipCode = zipCode;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Zips [id=" + id + ", createdAt=" + createdAt + ", zipCode=" + zipCode + "]";
	}
	
}
