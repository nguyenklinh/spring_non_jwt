package com.javaweb.api;

import java.nio.file.FileAlreadyExistsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingSearchCriteriaConverter;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.model.erroResponDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
import com.mysql.cj.jdbc.Driver;

import customexceptions.FieldRequiredException;


@RestController
//@PropertySource("classpath:application.properties")
//@Transactional
public class BuildingAPI {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingService buildingService;
	@GetMapping( value="/api/building/")
	public List<BuildingDTO> getBuilding(@ModelAttribute BuildingSearchCriteriaDTO buildingSearchCriteriaDTO) {
		BuildingSearchBuilder criteria = BuildingSearchCriteriaConverter.convertToentity(buildingSearchCriteriaDTO);
			List<BuildingDTO> result = buildingService.findAll(criteria);
		return result;	
	}

//	@GetMapping(value = "/api/building/{id}" )
//	public BuildingDTO getBuildingById(@PathVariable Long id) {
//		BuildingDTO result = new BuildingDTO();
//		BuildingEntity  Building = buildingRepository.getReferenceById(id);
//		String a = Building.getManagername();
//		return result;
//	}
//	
//	@DeleteMapping(value = "/api/building/{ids}" )
//	public BuildingDTO getBuildingById1(@PathVariable Long[] ids) {
//		BuildingDTO result = new BuildingDTO();
//		buildingRepository.deleteByIdIn(ids);
//		
//		return result;
//	}
}
