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
