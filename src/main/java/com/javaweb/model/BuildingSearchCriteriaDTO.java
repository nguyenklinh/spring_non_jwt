package com.javaweb.model;

import java.util.List;

public class BuildingSearchCriteriaDTO {
	private String name;
	private Integer floorarea;
	private Long districtId;
	private String ward;
	private String street;
	private Integer numberOfbasement;
	private String direction;
	private String level;
	private Double areaFrom;
    private Double areaTo;
    private Double priceFrom;
    private Double priceTo;
	private String managername;
	private String managerphonenumber;
    private List<String> typeCode;
    private Long staffId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
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
	public Integer getNumberOfbasement() {
		return numberOfbasement;
	}
	public void setNumberOfbasement(Integer numberOfbasement) {
		this.numberOfbasement = numberOfbasement;
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
	public Double getAreaFrom() {
		return areaFrom;
	}
	public void setAreaFrom(Double areaFrom) {
		this.areaFrom = areaFrom;
	}
	public Double getAreaTo() {
		return areaTo;
	}
	public void setAreaTo(Double areaTo) {
		this.areaTo = areaTo;
	}
	public Double getPriceFrom() {
		return priceFrom;
	}
	public void setPriceFrom(Double priceFrom) {
		this.priceFrom = priceFrom;
	}
	public Double getPriceTo() {
		return priceTo;
	}
	public void setPriceTo(Double priceTo) {
		this.priceTo = priceTo;
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
	public List<String> getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(List<String> typeCode) {
		this.typeCode = typeCode;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	@Override
	public String toString() {
		return "BuildingSearchCriteriaDTO [name=" + name + ", floorarea=" + floorarea + ", districtId=" + districtId
				+ ", ward=" + ward + ", street=" + street + ", numberOfbasement=" + numberOfbasement + ", direction="
				+ direction + ", level=" + level + ", areaFrom=" + areaFrom + ", areaTo=" + areaTo + ", priceFrom="
				+ priceFrom + ", priceTo=" + priceTo + ", managername=" + managername + ", managerphonenumber="
				+ managerphonenumber + ", typeCode=" + typeCode + ", staffId=" + staffId + "]";
	}
    
}
