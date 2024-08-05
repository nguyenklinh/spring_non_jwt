package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name= "building")

public class BuildingEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "numberofbasement")
	private Integer numberOfbasement;
	
	@Column(name= "ward")
	private String ward;
	
	@Column(name= "street")
	private String street;
	
//	@Column(name= "districtid")
//	private Long districtid;

	@Column(name= "floorarea")
	private Integer floorarea;
	
	@Column(name= "direction")
	private String direction;

	@Column(name= "level")
	private String level;
	
	@Column(name= "rentprice")
	private Integer rentprice;
	
	@Column(name= "managername")
	private String managername;
	
	@Column(name= "managerphonenumber")
	private String managerphonenumber;
	
//	@Column(name= "district")
//	private String district;
	
//	@Column(name= "rentalareas")
//	private String rentalAreas; 
	
	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity district;
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentareaEntity> items = new ArrayList<>(); 
	
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public List<RentareaEntity> getItems() {
		return items;
	}
	public void setItems(List<RentareaEntity> items) {
		this.items = items;
	}
//	public String getRentalAreas() {
//		return rentalAreas;
//	}
//	public void setRentalAreas(String rentalAreas) {
//		this.rentalAreas = rentalAreas;
//	}
//	public String getDistrict() {
//		return district;
//	}
//	public void setDistrict(String district) {
//		this.district = district;
//	}
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
//	public Long getDistrictid() {
//		return districtid;
//	}
//	public void setDistrictid(Long districtid) {
//		this.districtid = districtid;
//	}
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
