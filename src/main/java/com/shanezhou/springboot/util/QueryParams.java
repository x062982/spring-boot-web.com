package com.shanezhou.springboot.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 查询参数工具类
 * </p>
 *
 * @author zhouwx
 * @since 2020-06-24
 */
public class QueryParams {
    
    /**
     * 封装查询参数
     * @param <T>   类型
     * @param clazz 参数对应的类
     * @param params    参数    
     * @return  封装了参数的Map
     */
    public <T> Map<String, Object> getParams(Class<T> clazz, T params) {
        // 存放参数列表
        if (params != null) {
            Field[] fields = clazz.getDeclaredFields();
            Map<String, Object> paramsMap = new ConcurrentHashMap<>(fields.length);
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(params);
                    if(value != null) {
                        paramsMap.put(field.getName(), value);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return paramsMap;
        }
        return null;
    }


}