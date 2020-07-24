package com.shanezhou.springboot.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author ZhouWX
 * @CreateDate 2020/7/24 星期五
 */
public class LocalDateTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        //System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        String format = localDateTime.format(formatter);

        System.out.println(format);
        System.out.println(localDate.format(formatter));
        LocalDate parse = LocalDate.parse(format, formatter);
        System.out.println(parse);
        LocalDateTime from = LocalDateTime.from(parse);
        System.out.println(from + " from");

    }
}
