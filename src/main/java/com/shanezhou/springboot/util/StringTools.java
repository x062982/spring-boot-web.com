package com.shanezhou.springboot.util;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author ZhouWX
 * @CreateDate 2020/7/24 星期五
 */
public class StringTools {

    private static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");

    public void isNullToString(Object o) {

    }

    public static String isNullToString(String str) {
        return str == null ? "": str;
    }

    public static String isNullToString(Long l) {
        return l == null ? "" : String.valueOf(l);
    }

    public static String isNullToStringDate(LocalDateTime localDateTime) {
        return localDateTime == null ? "" : localDateTime.format(YYYY_MM_DD);
    }

    public static String isNullToStringTime(LocalDateTime localDateTime) {
        return localDateTime == null ? "" : localDateTime.format(YYYY_MM_DD_HH_MM_SS);
    }

    public static Long stringToLong(String str) {
        return StringUtils.isEmpty(str) ? null : Long.valueOf(str);
    }

    public static LocalDateTime stringToTime(String str) {
        int length = StringTools.isNullToString(str).trim().length();
        if (length > 10) {
            return LocalDateTime.parse(str);
        }
        return StringUtils.isEmpty(str) ? null :
                LocalDateTime.of(stringToDate(str), LocalTime.parse("00:00:00"));
    }

    public static LocalDate stringToDate(String str) {
        return StringUtils.isEmpty(str) ? null :
                LocalDate.parse(str, YYYY_MM_DD);
    }

    public static Object stringToType(Class clazz, String value) {
        String typeName = clazz.getTypeName();
        String type = typeName.substring(typeName.lastIndexOf(".") + 1).toLowerCase();
        switch (type) {
            case "string":
                return value;
            case "long":
                return Long.valueOf(value);
            case "int":
                return Integer.valueOf(value);
            case "localdatetime":
                return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            default:
                return value;
        }
    }
}
