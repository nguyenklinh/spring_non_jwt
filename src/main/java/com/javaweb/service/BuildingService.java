package com.javaweb.service;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchCriteriaDTO;


public interface BuildingService {

	List<BuildingDTO> FindAll(BuildingSearchBuilder buildingSearchBuilder);
}
