package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;


public interface BuildingService {
	List<BuildingDTO> FinAll(String name, Long districtId);
}
