package com.shanezhou.springboot.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户对象
 * @Author shaneZhou
 * @Time 2020/05/30 18:03 下午
 */
@Data
public class Employee {

    private int id;
    private String userName;
    private int deptId;
    private String password;
    private String email;
    private int age;
    private int gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Department department;

}
