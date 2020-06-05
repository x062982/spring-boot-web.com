package com.shanezhou.springboot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户对象
 * @Author shaneZhou
 * @Time 2020/05/30 18:03 下午
 */
@Data
@NoArgsConstructor
@KeySequence(value = "seq_emp_id", clazz = Integer.class)
public class Employee {

    @TableId(type = IdType.INPUT)
    private Integer id;
    @TableField(value = "username")
    private String userName;
    @TableField(fill = FieldFill.INSERT)
    private Integer deptId;
    @TableField(fill = FieldFill.INSERT)
    private String password;
    private String email;
    private Integer age;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @TableField(exist = false)
    private Department department;
    @Version
    private Integer version;

    public Employee(String userName) {
        this.userName = userName;
    }

    public Employee(String userName, Integer deptId) {
        this.userName = userName;
        this.deptId = deptId;
    }
}
