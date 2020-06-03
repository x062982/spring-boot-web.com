package com.shanezhou.springboot.dao;

import com.shanezhou.springboot.entity.Department;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 操作部门表
 * @Author ShaneZhou
 * @Time 2020/06/01 16:50:36
 */
@Component
public interface DepartmentMapper {

    /**
     * 根据部门编号查找部门
     * @param id    部门编号
     * @return
     */
    @Select("select * from department where id = #{id}")
    Department findById(int id);

    /**
     * 查询所有部门
     * @return
     */
    @Select("select * from department")
    List<Department> findAll();
}
