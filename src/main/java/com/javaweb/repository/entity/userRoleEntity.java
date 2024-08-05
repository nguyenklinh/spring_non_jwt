package com.javaweb.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class userRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private userEntity user;
	
	@ManyToOne
	@JoinColumn(name = "roleid")
	private roleEntity role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public userEntity getUser() {
		return user;
	}

	public void setUser(userEntity user) {
		this.user = user;
	}

	public roleEntity getRole() {
		return role;
	}

	public void setRole(roleEntity role) {
		this.role = role;
	}
	
}
