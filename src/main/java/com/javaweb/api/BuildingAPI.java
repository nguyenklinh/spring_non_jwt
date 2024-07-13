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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.erroResponDTO;
import com.javaweb.service.BuildingService;
import com.mysql.cj.jdbc.Driver;

import customexceptions.FieldRequiredException;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@GetMapping( value="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(name="name", required = false) String name,
										@RequestParam(name="districtid",required = false) Long district,
										@RequestParam(name="typeCode",required = false) List<String> typeCode) {
			List<BuildingDTO> result = buildingService.FinAll(name, district);
		return result;

		
	}
//	public void validate(BuildingDTO BuildingDTO) throws FieldRequiredException {
//		if (BuildingDTO.getName() == null || BuildingDTO.getName().equals("") || BuildingDTO.getNumberOfbasement()==null) {
//			throw new FieldRequiredException("name or getNumberOfbasement is null");
//		}
//	}
//	
//	@RequestMapping( value="/api/building/", method= RequestMethod.POST)
//	public void getBuilding2(@RequestParam Map<String, String> params ) {
//		System.out.println("ok");
//	}
//	@PostMapping( value="/api/building/")
//	public void getBuilding2(@RequestBody BuildingDTO  BuildingDTO) {
//		System.out.println("ok");
//	}
	
	@DeleteMapping(value = "/api/building/{id}/{name}" )
	public void deleteBuilding(@PathVariable Integer id,
			@PathVariable String name) {
		System.out.println("da xoa toa nha");
	}
}
