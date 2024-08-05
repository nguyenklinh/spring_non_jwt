package com.javaweb.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.DtabasejdbcUtil;

@Repository
@Primary
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
	
	
	public static void generateQueryConditions(BuildingSearchBuilder buildingSearchBuilder,StringBuilder sql) {
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
	}
	
	
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<BuildingEntity> FindAll(BuildingSearchBuilder buildingSearchBuilder) {
		
		StringBuilder sql =new StringBuilder("SELECT DISTINCT  b.*  FROM building b ");
		joinTable(buildingSearchBuilder, sql);
		sql.append(" where 1=1 ");
		generateQueryConditions(buildingSearchBuilder, sql);
		 Query query  = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
	}

}
