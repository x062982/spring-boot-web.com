package com.shanezhou.springboot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/5 星期三
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("STUDENT")
@KeySequence("SEQ_STUDENT_ID")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    @TableField("NAME")
    private String name;

    @TableField("BIRTHDAY")
    private LocalDateTime birthday;


}
