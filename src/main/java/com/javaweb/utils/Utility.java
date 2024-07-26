package com.javaweb.utils;

public class Utility {

    public static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isNotEmpty(Number number) {
        return number != null;
    }
}