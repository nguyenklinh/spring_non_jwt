package com.javaweb.utils;

public class BuildingSearchCriteriaUtil {
	public static <T> T checkEmpty(T value) {
		if (value instanceof String) {
			return (T) (value == null || ((String) value).trim().isEmpty() ? null : value);
		}
		return value == null ? null:value;
	}
}
