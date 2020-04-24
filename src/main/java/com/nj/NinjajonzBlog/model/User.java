package com.nj.NinjajonzBlog.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	
	@Length(min=3, message="Your username must be at least 3 characters")
	@Length(max=18, message="Your username cannot have more than 18 characters")
	@Pattern(regexp="[^\\s]+", message="Username cannot contain spaces")
	private String username;
	
	@Length(min=8, message="Your password must be at least 8 characters")
	private String password;
	
	@CreationTimestamp
	private Date createdAt;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	private Integer active;
	
	public User() {}

	public User(
			@Length(min = 3, message = "Your username must be at least 3 characters") @Length(max = 18, message = "Your username cannot have more than 18 characters") String username,
			@Length(min = 8, message = "Your password must be at least 8 characters") String password, Date createdAt, Set<Role> roles, Integer active) {
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
		this.roles = roles;
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", createdAt=" + createdAt
				+ "]";
	}
	
}
