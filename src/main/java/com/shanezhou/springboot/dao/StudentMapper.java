package com.shanezhou.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanezhou.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/5 星期三
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
