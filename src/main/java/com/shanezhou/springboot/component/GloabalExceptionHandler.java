package com.shanezhou.springboot.component;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常控制
 * @Author ShaneZhou
 * @Time 2020/06/01 09:20:54
 */
@ControllerAdvice
public class GloabalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public String exceptionHandler(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<>();
        map.put("101", "未知异常！");
        // 传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code", 500);
        return "forward:/error";
    }

    @ExceptionHandler({MyBatisSystemException.class})
    public String exceptionHandler(MyBatisSystemException e, HttpServletRequest request) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<>();
        map.put("102", "数据库系统异常！");
        // 传入自己的错误状态码,否则status==200，不会跳转到自定义的错误页面
        request.setAttribute("javax.servlet.error.status_code", 500);
        return "forward:/error";
    }

    @ExceptionHandler({SQLException.class})
    @ResponseBody
    public Map<String, Object> sqlExceptionHandler(SQLException e) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<>();
        map.put("103", "发生了数据库异常！");
        return map;
    }

    @ExceptionHandler({BadSqlGrammarException.class})
    public String badSqlGrammarExceptionHandler(BadSqlGrammarException e, HttpServletRequest request) {
        e.printStackTrace();
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("msg", e.getCause().getLocalizedMessage());
        // 自己定义的错误信息
        request.setAttribute("shaneEtx", map);
        return "forward:/error";
    }
}
