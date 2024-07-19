package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchCriteriaDTO;


public interface BuildingService {
	List<BuildingDTO> FinAll(BuildingSearchCriteriaDTO buildingSearchCriteriaDTO);
}
