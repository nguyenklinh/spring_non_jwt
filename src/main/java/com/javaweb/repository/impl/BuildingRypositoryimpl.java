package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRypositoryimpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3307/estatebasic";
	static final String USER = "root";
	static final String PASS = "admin123";

	@Override
	public List<BuildingEntity> FindAll(String name, Long districtId) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM building b where 1=1 ");
		if(name != null && !name.equals("")) {
			sql.append(" and b.name like '%"+ name+ "%' ");
		}
		if(districtId != null ) {
			sql.append(" and b.districtid = "+ districtId + " " );
		}
		List<BuildingEntity> result =new ArrayList<BuildingEntity>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) 
		
		{
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity(); 
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfbasement(rs.getInt("numberofbasement"));
				result.add(building);
			}
			System.out.println("ket noi data base thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ket noii data base that bai");
			// TODO: handle exception
		}
		return result;
	}
	
}
