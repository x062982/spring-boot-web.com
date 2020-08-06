package com.shanezhou.springboot.util;

import java.time.LocalTime;
import java.util.*;
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


    public static void findDiffWithTwoArr(int[] oldStrArr, int[] strArr) {
        int[] tempArr = new int[oldStrArr.length + strArr.length];

        List diffList = new ArrayList();
        for (int i = 0; i < oldStrArr.length; i++) {
            tempArr[oldStrArr[i]]++;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (tempArr[strArr[i]] == 0) {
                diffList.add(strArr[i]);
            }
        }
        System.out.println(Arrays.toString(diffList.toArray()));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
            int standard = arr[low];
            while (high > low) {
                while (high > low && arr[high] >= standard) {
                    high--;
                }
                arr[low] = arr[high];
                while (high > low && arr[low] <= standard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{12, 23, 21, 3, 4, 42};
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(20);
        }
        System.out.println(Arrays.toString(arr));
        long startTime = LocalTime.now().getNano();
        //findDiffWithTwoArr(arr, new int[]{2, 1});
        quickSort(arr, 0, arr.length - 1);
        long endTime = LocalTime.now().getNano();
        long diff = endTime - startTime;
        LocalTime localTime = LocalTime.ofNanoOfDay(diff);
        System.out.println(localTime);
        System.out.println(Arrays.toString(arr));
    }

}
