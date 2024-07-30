package com.javaweb.builder;

import java.util.List;

public class BuildingSearchBuilder {
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
    
    private BuildingSearchBuilder(Builder builder) {
    	this.name=builder.name;
    	this.floorarea = builder.floorarea;
    	this.districtId = builder.districtId;
    	this.ward = builder.ward;
    	this.street = builder.street;
    	this.numberOfbasement = builder.numberOfbasement;
    	this.direction = builder.direction;
    	this.level = builder.level;
    	this.areaFrom = builder.areaFrom;
    	this.areaTo = builder.areaTo;
    	this.priceFrom = builder.priceFrom;
    	this.priceTo = builder.priceTo;
    	this.managername = builder.managername;
    	this.managerphonenumber = builder.managerphonenumber;
    	this.typeCode = builder.typeCode;
    	this.staffId = builder.staffId;
    }
    
	public String getName() {
		return name;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Integer getNumberOfbasement() {
		return numberOfbasement;
	}
	public String getDirection() {
		return direction;
	}
	public String getLevel() {
		return level;
	}
	public Double getAreaFrom() {
		return areaFrom;
	}
	public Double getAreaTo() {
		return areaTo;
	}
	public Double getPriceFrom() {
		return priceFrom;
	}
	public Double getPriceTo() {
		return priceTo;
	}
	public String getManagername() {
		return managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public List<String> getTypeCode() {
		return typeCode;
	}
	public Long getStaffId() {
		return staffId;
	}
    
	public static class Builder {
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
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setFloorarea(Integer floorarea) {
			this.floorarea = floorarea;
			return this;
		}
		public Builder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setNumberOfbasement(Integer numberOfbasement) {
			this.numberOfbasement = numberOfbasement;
			return this;
		}
		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}
		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}
		public Builder setAreaFrom(Double areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}
		public Builder setAreaTo(Double areaTo) {
			this.areaTo = areaTo;
			return this;
		}
		public Builder setPriceFrom(Double priceFrom) {
			this.priceFrom = priceFrom;
			return this;
		}
		public Builder setPriceTo(Double priceTo) {
			this.priceTo = priceTo;
			return this;
		}
		public Builder setManagername(String managername) {
			this.managername = managername;
			return this;
		}
		public Builder setManagerphonenumber(String managerphonenumber) {
			this.managerphonenumber = managerphonenumber;
			return this;
		}
		public Builder setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
			return this;
		}
		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		public BuildingSearchBuilder build () {
			return new BuildingSearchBuilder(this);
		}
	    
		}
}
