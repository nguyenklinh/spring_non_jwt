package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
@Service
public class buildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BuildingDTO> FinAll(String name, Long districtId) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildinigEntities = buildingRepository.FindAll(name,districtId);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildinigEntities) {
			BuildingDTO building= new BuildingDTO();
			building.setName(item.getName());
			building.setNumberOfbasement(item.getNumberOfbasement());
			building.setAddress(item.getStreet()+","+item.getWard());
			result.add(building);
		}
		
		return result; 
	}

}
