package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class roleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<userRoleEntity> userRoleEntities = new ArrayList<>(); 
	
	public List<userRoleEntity> getUserRoleEntities() {
		return userRoleEntities;
	}

	public void setUserRoleEntities(List<userRoleEntity> userRoleEntities) {
		this.userRoleEntities = userRoleEntities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
