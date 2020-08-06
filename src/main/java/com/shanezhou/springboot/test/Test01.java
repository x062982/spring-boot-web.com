package com.shanezhou.springboot.test;


import com.shanezhou.springboot.entity.Student;
import com.shanezhou.springboot.util.StringTools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhouWX
 * @createDate 2020/6/30
 */
public class Test01 {

    public static void main(String[] args) throws NoSuchFieldException {
        Student student = new Student();
        Field field = student.getClass().getDeclaredField("birthday");
        Object o = StringTools.stringToType(field.getType(), "2020-12-03 00:00:00");
        student.setBirthday((LocalDateTime)o);
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