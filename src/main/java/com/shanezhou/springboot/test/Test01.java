package com.shanezhou.springboot.test;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhouWX
 * @createDate 2020/6/30
 */
public class Test01 {

    public static void main(String[] args) {

    }

}

class TestEnums<T> {

    public T getEnums(Class<T> clazz, int value) throws IllegalAccessException, InstantiationException {
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i]);

            }
            Method getValueMethod = clazz.getDeclaredMethod("getValue");
            T[] enumArr = clazz.getEnumConstants();
            for (int i = 0; i < enumArr.length; i++) {
                if ((int)getValueMethod.invoke(enumArr[i]) == value) {
                    return enumArr[i];
                }
            }
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}