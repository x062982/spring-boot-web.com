package com.shanezhou.springboot.util;

import com.shanezhou.springboot.enums.CommentStatusEnum;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ShaneZhou
 * @since 2020/9/8 周二
 */
public class CommonEnumType<T> {
    private static final String FIELD_DESC = "desc";
    private static final String FIELD_VALUE = "value";

    private Class<T> clazz;

    public CommonEnumType(Class<T> clazz) {
        this.clazz = clazz;
    }

    public static void main(String[] args) {
        CommonEnumType<CommentStatusEnum> status = new CommonEnumType<>(CommentStatusEnum.class);
        Field[] f =  status.clazz.getDeclaredFields();
        System.out.println(f.toString());
        System.out.println(status.clazz.getEnumConstants()[0]);
    }
    /**
     * 根据传入的值获取枚举信息
     * @param value 参数值
     * @return  枚举信息
     */
    public T getEnum(int value) {
        T[] enumConstants = clazz.getEnumConstants();
        try {
            // 获取该方法
            Method method = clazz.getDeclaredMethod("getValue");
            method.setAccessible(true);
            for (T constant : enumConstants){
                if (value == (int)method.invoke(constant)) {
                    return constant;
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  转化为Map
     * @param clazz 传入的类
     * @return
     */
    public Map<String, Map<String, Object>> toMap(Class<T> clazz) {
        T[] enumConstants = clazz.getEnumConstants();
        Map<String, Map<String, Object>> enumMap = new HashMap<>();
        try {
            Method method = clazz.getDeclaredMethod("getValue");
            method.setAccessible(true);

            for (T constant : enumConstants) {
                Map<String, Object> map = new HashMap<>();
                T anEnum = getEnum((int)method.invoke(constant));
                Class<T> enumClazz = (Class<T>)anEnum.getClass();
                Field fieldDesc = enumClazz.getDeclaredField(FIELD_DESC);
                Field fieldValue = enumClazz.getDeclaredField(FIELD_VALUE);
                head2UpperCase(FIELD_DESC);
                head2UpperCase(FIELD_VALUE);
                String methodGetDesc = "get" + FIELD_DESC;
                String methodGetValue = "get" + FIELD_VALUE;
                fieldDesc.setAccessible(true);
                fieldValue.setAccessible(true);
                map.put(FIELD_DESC, enumClazz.getDeclaredMethod(methodGetDesc).invoke(constant));
                map.put(FIELD_VALUE, enumClazz.getDeclaredMethod(methodGetValue).invoke(constant));
                // 得到数据放入map中
                enumMap.put(anEnum.toString(), map);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return enumMap;
    }

    /**
     * 转化为list
     * @param clazz 传入的类
     * @return
     */
    public List<Map<String, Object>> toList(Class<T> clazz) {
        T[] enumConstants = clazz.getEnumConstants();
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            Method method = clazz.getDeclaredMethod("getValue");
            method.setAccessible(true);

            for (T constant : enumConstants) {
                Map<String, Object> map = new HashMap<>();
                T anEnum = getEnum((int)method.invoke(constant));
                Class<T> enumClazz = (Class<T>)anEnum.getClass();
                Field fieldDesc = enumClazz.getDeclaredField(FIELD_DESC);
                Field fieldValue = enumClazz.getDeclaredField(FIELD_VALUE);
                head2UpperCase(FIELD_DESC);
                head2UpperCase(FIELD_VALUE);
                String methodGetDesc = "get" + FIELD_DESC;
                String methodGetValue = "get" + FIELD_VALUE;
                fieldDesc.setAccessible(true);
                fieldValue.setAccessible(true);
                map.put(FIELD_DESC, enumClazz.getDeclaredMethod(methodGetDesc).invoke(constant));
                map.put(FIELD_VALUE, enumClazz.getDeclaredMethod(methodGetValue).invoke(constant));

                list.add(map);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 首字母大写
     * @param str   字符串
     */
    public void head2UpperCase(String str) {
        char[] chars = str.toCharArray();
        if (chars[0] > 96 && chars[0] < 123) {
            chars[0] ^= 32;
        }
        str = new String(chars);
    }
}
