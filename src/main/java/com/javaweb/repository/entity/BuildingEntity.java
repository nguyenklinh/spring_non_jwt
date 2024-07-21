package com.javaweb.repository.entity;

import java.util.List;

public class BuildingEntity {
	private Long id;
	private String name;
	private Integer numberOfbasement;
	private String ward;
	private String street;
	private Long districtid;
	private Integer floorarea;
	private String direction;
	private String level;
	private Integer rentprice;
	private String managername;
	private String managerphonenumber;
	private String district;
	private List<Double> rentalAreas; 
	
	public List<Double> getRentalAreas() {
		return rentalAreas;
	}
	public void setRentalAreas(List<Double> rentalAreas) {
		this.rentalAreas = rentalAreas;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfbasement() {
		return numberOfbasement;
	}
	public void setNumberOfbasement(Integer numberOfbasement) {
		this.numberOfbasement = numberOfbasement;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Long getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		

}
