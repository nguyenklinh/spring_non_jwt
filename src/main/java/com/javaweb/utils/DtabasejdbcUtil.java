package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class DtabasejdbcUtil {
	private  static final String DB_URL = "jdbc:mysql://localhost:3307/estatebasic";
	private  static final String USER = "root";
	private  static final String PASS = "admin123";
	
	public static Connection getConnection() throws  SQLException{
		return DriverManager.getConnection(DB_URL,USER,PASS);
	}
	
	public static String buildCondition(String column, Object value, String operator, boolean isLike) {
        if (value == null) {
            return "";
        }
        if (isLike) {
            return " AND " + column + " LIKE '%" + value + "%'";
        }
        return " AND " + column + operator + value;
    }

    public static String buildInCondition(String column, List<String> values) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        String joinedValues = values.stream()
                .map(value -> "'" + value + "'")
                .collect(Collectors.joining(","));
        return " AND " + column + " IN (" + joinedValues + ")";
    }
}
