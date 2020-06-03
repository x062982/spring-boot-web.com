package com.shanezhou.springboot.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入自己定义的ErrorAttributes，用于定制错误信息
 * @Author ShaneZhou
 * @Time 2020/06/01 15:54:01
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 返回的map就是页面和json能获取的所有字段
     * @param webRequest
     * @param options
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("company", "四特酒信息化处");
        Map<String, Object> mapEtx = (Map<String, Object>)webRequest.getAttribute("shaneEtx", 0);
        map.put("shaneEtx", mapEtx);
        return map;
    }
}
