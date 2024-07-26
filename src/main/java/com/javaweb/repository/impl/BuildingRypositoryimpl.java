package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.Utility;
import com.javaweb.utils.connectDtabasejdbcUtil;

@Repository
public class BuildingRypositoryimpl implements BuildingRepository{


	public static void joinTable(BuildingSearchCriteriaDTO buildingSearchCriteriaDTO,StringBuilder sql) { 
		if(buildingSearchCriteriaDTO.getStaffId() != null) {
			sql.append(" left JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		if(buildingSearchCriteriaDTO.getTypeCode() != null && !buildingSearchCriteriaDTO.getTypeCode().isEmpty()) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype ON buildingrenttype.renttypeid = renttype.id ");
		}
		if(buildingSearchCriteriaDTO.getPriceFrom() != null && buildingSearchCriteriaDTO.getPriceTo() != null) {
			sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
		}
	}
	
	
	@Override
	public List<BuildingEntity> FindAll(BuildingSearchCriteriaDTO buildingSearchCriteriaDTO) {
		// TODO Auto-generated method stub
//		, district.name AS district_name, rentarea.value AS rental_area
		StringBuilder sql = new StringBuilder("SELECT DISTINCT  b.*  FROM building b ");
		
		joinTable(buildingSearchCriteriaDTO, sql);
		
		sql.append(" where 1=1 ");
		 if (Utility.isNotEmpty(buildingSearchCriteriaDTO.getName())) {
			 sql.append(" and b.name like '%"+ buildingSearchCriteriaDTO.getName()+ "%' ");
	        }
		
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getFloorarea())) {
			 sql.append(" and b.floorarea = " + buildingSearchCriteriaDTO.getFloorarea() );
		 }
		 
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getDistrictId()) ) {
				sql.append(" and b.districtid = "+ buildingSearchCriteriaDTO.getDistrictId() + " " );
			}
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getWard())) {
			 sql.append(" and b.ward like '%"+ buildingSearchCriteriaDTO.getWard()+ "%' ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getStreet()) ) {
			 sql.append(" and b.street like '%"+ buildingSearchCriteriaDTO.getStreet()+ "%' ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getNumberOfbasement())) {
				sql.append(" and b.numberofbasement = "+ buildingSearchCriteriaDTO.getNumberOfbasement() + " " );
			}
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getDirection() ) ) {
			 sql.append(" and b.direction like '%"+ buildingSearchCriteriaDTO.getDirection()+ "%' ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getLevel()) ) {
			 sql.append(" and b.level like '%"+ buildingSearchCriteriaDTO.getLevel()+ "%' ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getAreaFrom() )) {
			 sql.append(" and rentarea.value >="+ buildingSearchCriteriaDTO.getAreaFrom() + " ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getAreaTo())) {
			 sql.append(" and rentarea.value <="+ buildingSearchCriteriaDTO.getAreaTo() + " ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getPriceFrom())) {
			 sql.append(" and b.rentprice >="+ buildingSearchCriteriaDTO.getPriceFrom()+ " ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getAreaTo())) {
			 sql.append(" and b.rentprice <="+ buildingSearchCriteriaDTO.getPriceTo()+ " ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getManagername())) {
			 sql.append(" and b.managername like '%"+ buildingSearchCriteriaDTO.getManagername()+"%' ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getManagerphonenumber())) {
			 sql.append(" and b.managerphonenumber like '%"+ buildingSearchCriteriaDTO.getManagerphonenumber() + "%' ");
		 }
		 if(Utility.isNotEmpty(buildingSearchCriteriaDTO.getStaffId())) {
			 sql.append(" and assignmentbuilding.staffid ="+ buildingSearchCriteriaDTO.getStaffId()+ " ");
		 }
		 
		 if (buildingSearchCriteriaDTO.getTypeCode() != null && !buildingSearchCriteriaDTO.getTypeCode().isEmpty()) {
			 
			 String typecodes = buildingSearchCriteriaDTO.getTypeCode().stream()
					 			.map(it-> "'" + it + "'")
					 			.collect(Collectors.joining(","));
			 
			 sql.append(" AND renttype.code IN (").append(typecodes).append(")");
		 }
//		 if (buildingSearchCriteriaDTO.getTypeCode() != null && !buildingSearchCriteriaDTO.getTypeCode().isEmpty()) {
//	            sql.append(" AND renttype.code IN (");
//	            for (int i = 0; i < buildingSearchCriteriaDTO.getTypeCode().size(); i++) {
//	                sql.append("'").append(buildingSearchCriteriaDTO.getTypeCode().get(i)).append("'");
//	                if (i < buildingSearchCriteriaDTO.getTypeCode().size() - 1) {
//	                    sql.append(", ");
//	                }
//	            }
//	            sql.append(")");
//	        }
		 
		 List<BuildingEntity> resul = new ArrayList<BuildingEntity>();
		try(Connection conn = connectDtabasejdbcUtil.getConnection();
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) 
		
		{
			while(rs.next()) {
					BuildingEntity building = new BuildingEntity();
                    building.setId(rs.getLong("id")); 
					building.setName(rs.getString("name"));
					building.setStreet(rs.getString("street"));
					building.setWard(rs.getString("ward"));
					building.setDistrictid(rs.getLong("districtid"));
					building.setNumberOfbasement(rs.getInt("numberofbasement"));
					building.setFloorarea(rs.getInt("floorarea"));
					building.setDirection(rs.getString("direction"));
					building.setLevel(rs.getString("level"));
					building.setRentprice(rs.getInt("rentprice"));
					building.setManagername(rs.getString("managername"));
					building.setManagerphonenumber(rs.getString("managerphonenumber"));
					resul.add(building);
				
			}
			System.out.println("ket noi data base thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ket noii data base that bai");
			// TODO: handle exception
		}
		
		return resul;
	}

	
	
}
