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

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.Utility;
import com.javaweb.utils.DtabasejdbcUtil;

@Repository
public class BuildingRypositoryimpl implements BuildingRepository{


	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder,StringBuilder sql) { 
		if(buildingSearchBuilder.getStaffId() != null) {
			sql.append(" left JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		if(buildingSearchBuilder.getTypeCode() != null && !buildingSearchBuilder.getTypeCode().isEmpty()) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype ON buildingrenttype.renttypeid = renttype.id ");
		}
		if(buildingSearchBuilder.getAreaFrom() != null || buildingSearchBuilder.getAreaTo() != null) {
			sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
		}
	}
	
	
	@Override
	public List<BuildingEntity> FindAll(BuildingSearchBuilder buildingSearchBuilder) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT DISTINCT  b.*  FROM building b ");
		
		joinTable(buildingSearchBuilder, sql);
		
		sql.append(" where 1=1 ");

		 Map<String, Object> conditions = new HashMap<>();
	        conditions.put("b.name", buildingSearchBuilder.getName());
	        conditions.put("b.floorarea", buildingSearchBuilder.getFloorarea());
	        conditions.put("b.districtid", buildingSearchBuilder.getDistrictId());
	        conditions.put("b.ward", buildingSearchBuilder.getWard());
	        conditions.put("b.street", buildingSearchBuilder.getStreet());
	        conditions.put("b.numberofbasement", buildingSearchBuilder.getNumberOfbasement());
	        conditions.put("b.direction", buildingSearchBuilder.getDirection());
	        conditions.put("b.level", buildingSearchBuilder.getLevel());
	        conditions.put("rentarea.value >", buildingSearchBuilder.getAreaFrom());
	        conditions.put("rentarea.value <", buildingSearchBuilder.getAreaTo());
	        conditions.put("b.rentprice >", buildingSearchBuilder.getPriceFrom());
	        conditions.put("b.rentprice <", buildingSearchBuilder.getPriceTo());
	        conditions.put("b.managername", buildingSearchBuilder.getManagername());
	        conditions.put("b.managerphonenumber", buildingSearchBuilder.getManagerphonenumber());
	        conditions.put("assignmentbuilding.staffid", buildingSearchBuilder.getStaffId());

	        conditions.forEach((column, value) -> {
	            if (value != null) {
	                sql.append(DtabasejdbcUtil.buildCondition(column, value, "="));
	            }
	        });

	        sql.append(DtabasejdbcUtil.buildInCondition("renttype.code", buildingSearchBuilder.getTypeCode()));

		 
		 List<BuildingEntity> resul = new ArrayList<BuildingEntity>();
		try(Connection conn = DtabasejdbcUtil.getConnection();
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
