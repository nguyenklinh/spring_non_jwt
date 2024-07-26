package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.utils.connectDtabasejdbcUtil;
@Repository
public class DistrictRepositoryimpl implements DistrictRepository{

	@Override
	public DistrictEntity findNameById(Long id) {
		DistrictEntity districtEntity = new DistrictEntity();
		String sql = "SELECT DISTINCT  d.name  FROM district d where d.id = " + id + "; " ;
		try(Connection conn = connectDtabasejdbcUtil.getConnection();
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			while(rs.next()) {
				districtEntity.setName(rs.getString("name"));
					
				}
			}
			
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return districtEntity;
	}

}
