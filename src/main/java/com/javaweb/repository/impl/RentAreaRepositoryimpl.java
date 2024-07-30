package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentareaEntity;
import com.javaweb.utils.DtabasejdbcUtil;
@Repository
public class RentAreaRepositoryimpl implements RentAreaRepository{
	
	@Override
	public List<RentareaEntity> getValueByBuildingId(Long buildingid) {
		// TODO Auto-generated method stub
		List<RentareaEntity> rentarea = new ArrayList<RentareaEntity>();
		String sql = "SELECT DISTINCT  r.*  FROM rentarea r where r.buildingid = " + buildingid + "; " ;
		try(Connection conn = DtabasejdbcUtil.getConnection();
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			
			while(rs.next()) {
				RentareaEntity rentareaEntity = new RentareaEntity();
				rentareaEntity.setValue(rs.getLong("value"));
				rentarea.add(rentareaEntity);
				}
			}
			
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return rentarea;
	}

}
