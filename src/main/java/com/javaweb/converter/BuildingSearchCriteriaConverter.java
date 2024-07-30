package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.utils.BuildingSearchCriteriaUtil;

public class BuildingSearchCriteriaConverter {
	public static BuildingSearchBuilder convertToentity(BuildingSearchCriteriaDTO dto) {
		return  new  BuildingSearchBuilder.Builder()
				 .setName(BuildingSearchCriteriaUtil.checkEmpty(dto.getName()))
		            .setFloorarea(BuildingSearchCriteriaUtil.checkEmpty(dto.getFloorarea()))
		            .setDistrictId(BuildingSearchCriteriaUtil.checkEmpty(dto.getDistrictId()))
		            .setWard(BuildingSearchCriteriaUtil.checkEmpty(dto.getWard()))
		            .setStreet(BuildingSearchCriteriaUtil.checkEmpty(dto.getStreet()))
		            .setNumberOfbasement(BuildingSearchCriteriaUtil.checkEmpty(dto.getNumberOfbasement()))
		            .setDirection(BuildingSearchCriteriaUtil.checkEmpty(dto.getDirection()))
		            .setLevel(BuildingSearchCriteriaUtil.checkEmpty(dto.getLevel()))
		            .setAreaFrom(BuildingSearchCriteriaUtil.checkEmpty(dto.getAreaFrom()))
		            .setAreaTo(BuildingSearchCriteriaUtil.checkEmpty(dto.getAreaTo()))
		            .setPriceFrom(BuildingSearchCriteriaUtil.checkEmpty(dto.getPriceFrom()))
		            .setPriceTo(BuildingSearchCriteriaUtil.checkEmpty(dto.getPriceTo()))
		            .setManagername(BuildingSearchCriteriaUtil.checkEmpty(dto.getManagername()))
		            .setManagerphonenumber(BuildingSearchCriteriaUtil.checkEmpty(dto.getManagerphonenumber()))
		            .setTypeCode(dto.getTypeCode()) 
		            .setStaffId(BuildingSearchCriteriaUtil.checkEmpty(dto.getStaffId()))
		            .build();
	}
}
