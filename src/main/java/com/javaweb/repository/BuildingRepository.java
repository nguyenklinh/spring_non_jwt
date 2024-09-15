package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom{
	
	List<BuildingEntity> findByName(String s);

}
