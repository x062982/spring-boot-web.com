package com.shanezhou.springboot.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ZhouWX
 * @CreateDate 2020/7/22 星期三
 */
public class CommonUtils {

    /**
     * 驼峰转下划线
     * @param str
     * @return
     */
    public static String hump2underLine(String str) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(str);
        boolean isMatch = matcher.find();
        if (!isMatch) {
            return str;
        }
        StringBuilder s = new StringBuilder();
        while (isMatch) {
            int index = matcher.start();
            if (index == 0 || index == str.length()) {
                matcher.appendReplacement(s, matcher.group().toLowerCase());
            } else {
                matcher.appendReplacement(s, "_" + matcher.group().toLowerCase());
            }
            isMatch = matcher.find();
        }
        matcher.appendTail(s);
        return s.toString();

    }

    public static void main(String[] args) {
        String s = hump2underLine("aadFwadsAwDd");
        System.out.println(s);
    }
}
