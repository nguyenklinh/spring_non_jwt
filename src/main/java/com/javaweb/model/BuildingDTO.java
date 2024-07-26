package com.javaweb.model;

import java.util.List;

public class BuildingDTO {
	private String name;
	private String address;
	private Integer numberOfbasement;
	private String managername;
	private String managerphonenumber;
	private Integer floorarea;
	private Integer rentprice;
	private String rentalAreas;
	
	
	
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
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
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
	public String getAddress() { 
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRentalAreas() {
		return rentalAreas;
	}
	public void setRentalAreas(String list) {
		this.rentalAreas = list;
	}
	
	
}
