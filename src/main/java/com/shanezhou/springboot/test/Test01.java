package com.shanezhou.springboot.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhouWX
 * @createDate 2020/6/30
 */
public class Test01 {

    public static void main(String[] args) {
        //                  0    5   10  13
        hump2underLine("ad");
    }

    public static String hump2underLine(String str) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(str);
        StringBuilder s = new StringBuilder();
        while (matcher.find()) {
            int index = matcher.start();
            if (index == 0) {
                matcher.appendReplacement(s, matcher.group().toLowerCase());
            } else {
                matcher.appendReplacement(s, "_" + matcher.group().toLowerCase());
            }
            matcher.appendTail(s);
            System.out.println(s);
        }
        System.out.println(str);
        return s.toString();
    }
}
