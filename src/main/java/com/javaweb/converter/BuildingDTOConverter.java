package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentareaEntity;

@Component

public class BuildingDTOConverter {

	@Autowired 
	private ModelMapper modelMapper;
	public  BuildingDTO toBuildingDTO( BuildingEntity item) {
		BuildingDTO building= modelMapper.map(item, BuildingDTO.class);
		
		building.setAddress(item.getStreet()+","+item.getWard()+ "," +item.getDistrict().getName());
		
		List<RentareaEntity> rentareas = item.getItems(); 
		String rentalAreas = rentareas.stream()
                .map(RentareaEntity::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(" , "));
		building.setRentalAreas(rentalAreas);
//            building.setName(item.getName());
//    		building.setNumberOfbasement(item.getNumberOfbasement());
//    		building.setManagername(item.getManagername());
//    		building.setManagerphonenumber(item.getManagerphonenumber());
//    		building.setFloorarea(item.getFloorarea());
//    		building.setRentprice(item.getRentprice());
		
		return building;
	}
}
