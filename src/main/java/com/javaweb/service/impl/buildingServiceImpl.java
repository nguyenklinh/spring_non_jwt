package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
@Service
public class buildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BuildingDTO> FinAll(BuildingSearchCriteriaDTO buildingSearchCriteriaDTO) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildinigEntities = buildingRepository.FindAll(buildingSearchCriteriaDTO);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildinigEntities) {
			BuildingDTO building= new BuildingDTO();
			building.setName(item.getName());
			building.setNumberOfbasement(item.getNumberOfbasement());
			building.setAddress(item.getStreet()+","+item.getWard()+ "," +item.getDistrict());
			building.setManagername(item.getManagername());
			building.setManagerphonenumber(item.getManagerphonenumber());
			building.setFloorarea(item.getFloorarea());
			building.setRentprice(item.getRentprice());
			building.setRentalAreas(item.getRentalAreas());
			result.add(building);
		}
		
		return result; 
	}

}
