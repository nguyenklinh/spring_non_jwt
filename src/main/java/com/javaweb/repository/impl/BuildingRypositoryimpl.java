package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingSearchCriteriaDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRypositoryimpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3307/estatebasic";
	static final String USER = "root";
	static final String PASS = "admin123";

	@Override
	public List<BuildingEntity> FindAll(BuildingSearchCriteriaDTO buildingSearchCriteriaDTO) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT DISTINCT  b.*, district.name AS district_name, rentarea.value AS rental_area  FROM building b ");
		sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
		sql.append(" INNER JOIN renttype ON buildingrenttype.renttypeid = renttype.id ");
		sql.append("JOIN district ON b.districtid = district.id");
		sql.append(" left JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid WHERE 1=1 ");
		 if (buildingSearchCriteriaDTO.getName() != null && !buildingSearchCriteriaDTO.getName().equals("")) {
			 sql.append(" and b.name like '%"+ buildingSearchCriteriaDTO.getName()+ "%' ");
	        }
		
		 if(buildingSearchCriteriaDTO.getFloorarea() != null) {
			 sql.append(" and b.floorarea = " + buildingSearchCriteriaDTO.getFloorarea() );
		 }
		 
		 if(buildingSearchCriteriaDTO.getDistrictId() != null ) {
				sql.append(" and b.districtid = "+ buildingSearchCriteriaDTO.getDistrictId() + " " );
			}
		 if(buildingSearchCriteriaDTO.getWard() != null && !buildingSearchCriteriaDTO.getWard().equals("") ) {
			 sql.append(" and b.ward like '%"+ buildingSearchCriteriaDTO.getWard()+ "%' ");
		 }
		 if(buildingSearchCriteriaDTO.getStreet() != null && !buildingSearchCriteriaDTO.getStreet().equals("") ) {
			 sql.append(" and b.street like '%"+ buildingSearchCriteriaDTO.getStreet()+ "%' ");
		 }
		 if(buildingSearchCriteriaDTO.getNumberOfbasement() != null ) {
				sql.append(" and b.numberofbasement = "+ buildingSearchCriteriaDTO.getNumberOfbasement() + " " );
			}
		 if(buildingSearchCriteriaDTO.getDirection() != null && !buildingSearchCriteriaDTO.getDirection().equals("") ) {
			 sql.append(" and b.direction like '%"+ buildingSearchCriteriaDTO.getDirection()+ "%' ");
		 }
		 if(buildingSearchCriteriaDTO.getLevel() != null && !buildingSearchCriteriaDTO.getLevel().equals("") ) {
			 sql.append(" and b.level like '%"+ buildingSearchCriteriaDTO.getLevel()+ "%' ");
		 }
		 if(buildingSearchCriteriaDTO.getAreaFrom() != null ) {
			 sql.append(" and rentarea.value >="+ buildingSearchCriteriaDTO.getAreaFrom() + " ");
		 }
		 if(buildingSearchCriteriaDTO.getAreaTo() != null) {
			 sql.append(" and rentarea.value <="+ buildingSearchCriteriaDTO.getAreaTo() + " ");
		 }
		 if(buildingSearchCriteriaDTO.getPriceFrom() != null) {
			 sql.append(" and b.rentprice >="+ buildingSearchCriteriaDTO.getPriceFrom()+ " ");
		 }
		 if(buildingSearchCriteriaDTO.getAreaTo() != null) {
			 sql.append(" and b.rentprice <="+ buildingSearchCriteriaDTO.getPriceTo()+ " ");
		 }
		 if(buildingSearchCriteriaDTO.getManagername() != null && !buildingSearchCriteriaDTO.getManagername().equals("")) {
			 sql.append(" and b.managername like '%"+ buildingSearchCriteriaDTO.getManagername()+"%' ");
		 }
		 if(buildingSearchCriteriaDTO.getManagerphonenumber() != null && !buildingSearchCriteriaDTO.getManagerphonenumber().equals("")) {
			 sql.append(" and b.managerphonenumber like '%"+ buildingSearchCriteriaDTO.getManagerphonenumber() + "%' ");
		 }
		 if(buildingSearchCriteriaDTO.getStaffId() != null) {
			 sql.append(" and assignmentbuilding.staffid ="+ buildingSearchCriteriaDTO.getStaffId()+ " ");
		 }
		 if (buildingSearchCriteriaDTO.getTypeCode() != null && !buildingSearchCriteriaDTO.getTypeCode().isEmpty()) {
	            sql.append(" AND renttype.code IN (");
	            for (int i = 0; i < buildingSearchCriteriaDTO.getTypeCode().size(); i++) {
	                sql.append("'").append(buildingSearchCriteriaDTO.getTypeCode().get(i)).append("'");
	                if (i < buildingSearchCriteriaDTO.getTypeCode().size() - 1) {
	                    sql.append(", ");
	                }
	            }
	            sql.append(")");
	        }
		 
		 Map<Long, BuildingEntity> buildingMap = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) 
		
		{
			while(rs.next()) {
				Long buildingId = rs.getLong("id");
                BuildingEntity building = buildingMap.get(buildingId);
				if(building == null){
					building = new BuildingEntity();
                    building.setId(buildingId); 
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
					building.setDistrict(rs.getString("district_name"));
                    building.setRentalAreas(new ArrayList<>());
                    buildingMap.put(buildingId, building);
				}
				
				building.getRentalAreas().add(rs.getDouble("rental_area"));
			}
			System.out.println("ket noi data base thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ket noii data base that bai");
			// TODO: handle exception
		}
		List<BuildingEntity> res = new ArrayList<>(buildingMap.values());
		
		return new ArrayList<>(buildingMap.values());
	}

	
	
}
