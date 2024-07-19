package com.javaweb.repository;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {

	List<BuildingEntity> FindAll(BuildingSearchCriteriaDTO buildingSearchCriteriaDTO);

}
